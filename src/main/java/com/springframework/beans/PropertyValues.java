package com.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author G
 * @create 2023-03-10 1:25 AM
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList= new ArrayList<>();



    public void addPropertyValue(PropertyValue propertyValue){
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue currentPropertyValue = this.propertyValueList.get(i);
            if(currentPropertyValue.getName().equals(propertyValue.getName())){
                this.propertyValueList.set(i,propertyValue);
                return ;
            }
        }
        this.propertyValueList.add(propertyValue);
    }
    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }
    public PropertyValue getPropertyValue(String propertyName){
        for (int i = 0; i <this.propertyValueList.size(); i++) {
            PropertyValue propertyValue = propertyValueList.get(i);
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}
