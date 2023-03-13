package com.springframework.beans.factory.support;

import cn.hutool.core.io.resource.Resource;
import com.springframework.beans.BeansException;
import com.springframework.beans.factory.config.BeanDefinition;
import com.springframework.core.io.DefaultResourceLoader;
import com.springframework.core.io.ResourceLoader;

/**
 * @author G
 * @create 2023-03-10 4:44 PM
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private  final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
    this(registry,new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }


    @Override
    public BeanDefinitionRegistry getRegister() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public void loadBeanDefinitions(String[] locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }


}
