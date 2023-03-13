package com.springframework.context;

import com.springframework.beans.factory.HierarchicalBeanFactory;
import com.springframework.beans.factory.ListableBeanFactory;
import com.springframework.core.io.ResourceLoader;

/**
 * @author G
 * @create 2023-03-11 4:54 PM
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
