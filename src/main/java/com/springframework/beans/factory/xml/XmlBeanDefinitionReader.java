package com.springframework.beans.factory.xml;


import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.springframework.beans.BeansException;
import com.springframework.beans.PropertyValue;
import com.springframework.beans.factory.config.BeanDefinition;
import com.springframework.beans.factory.config.BeanReference;
import com.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.springframework.beans.factory.support.BeanDefinitionReader;
import com.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.springframework.core.io.ResourceLoader;
import com.springframework.core.io.Resource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import org.dom4j.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author G
 * @create 2023-03-10 4:53 PM
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public static final String BEAN_ELEMENT = "bean";
    public static final String PROPERTY_ELEMENT = "property";
    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String REF_ATTRIBUTE = "ref";
    public static final String INIT_METHOD_ATTRIBUTE = "init-method";
    public static final String DESTROY_METHOD_ATTRIBUTE = "destroy-method";
    public static final String SCOPE_ATTRIBUTE = "scope";

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }





    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try{
            InputStream inputStream = resource.getInputStream();
            try{
                doLoadBeanDefinitions(inputStream);
            }finally {
                inputStream.close();
            }
        }catch (IOException | DocumentException e){
            throw new BeansException("IOException or DocumentException parsing XML document from "+resource,e);
        }
    }


    //TODO
    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }


    protected void doLoadBeanDefinitions(InputStream inputStream) throws DocumentException {
//        使用dom4j读取XML
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);

//        获取XML的根元素
        Element beans = document.getRootElement();
        List<Element> beanList = beans.elements(BEAN_ELEMENT);

        for(Element  bean : beanList){
            String beanID = bean.attributeValue(ID_ATTRIBUTE);
            String beanName = bean.attributeValue(NAME_ATTRIBUTE);
            String className = bean.attributeValue(CLASS_ATTRIBUTE);
            String initMethodName = bean.attributeValue(INIT_METHOD_ATTRIBUTE);
            String destroyMethodName=bean.attributeValue(DESTROY_METHOD_ATTRIBUTE);
            String beanScope =bean.attributeValue(SCOPE_ATTRIBUTE);

                    //实例化className
                    Class<?> clazz ;
                    try {
                        clazz = Class.forName(className);
                    } catch (ClassNotFoundException e) {
                        throw new BeansException("Cannot find class [" + className + "]");
                    }
                    //优先匹配ID
                   beanName = StrUtil.isNotEmpty(beanID) ? beanID : beanName;
                    //如果XML中没给ID也没给NAME，将类名的第一个字母小写后作为BEAN的名字
                    if(StrUtil.isEmpty(beanName)){
//                        类的简写名字
                        beanName = StrUtil.lowerFirst( clazz.getSimpleName());
                    }

                    //装配属性节点

                    BeanDefinition beanDefinition = new BeanDefinition(clazz);
                    beanDefinition.setInitMethodName(initMethodName);
                    beanDefinition.setDestroyMethodName(destroyMethodName);
                    if (StrUtil.isNotEmpty(beanScope)) {
                        beanDefinition.setScope(beanScope);
                    }

            List<Element> propertyList = bean.elements(PROPERTY_ELEMENT);
                    for(Element property : propertyList) {

                        String propertyNameAttribute = property.attributeValue(NAME_ATTRIBUTE);
                        String propertyValueAttribute = property.attributeValue(VALUE_ATTRIBUTE);
                        String propertyRefAttribute = property.attributeValue(REF_ATTRIBUTE);

                          if (StrUtil.isEmpty(propertyNameAttribute)) {
                            throw new BeansException("The name attribute cannot be null or empty");
                         }


                        Object value = propertyValueAttribute;
                                //如果有ref 先装配成ref
                                if(StrUtil.isNotEmpty(propertyRefAttribute)){
                                   value = new BeanReference(propertyNameAttribute);
                                }
                                //装配name
                                PropertyValue propertyValue = new PropertyValue(propertyNameAttribute, value);
                                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
                            }

                    if(getRegister().containsBeanDefinition(beanName)){
                        //beanName不可以从重复
                        throw  new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
                    }

                    //注册BeanDefinition
                    getRegister().registerBeanDefinition(beanName,beanDefinition);
                }
            }

        }


