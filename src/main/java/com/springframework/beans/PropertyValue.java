package com.springframework.beans;

/**
 * @author G
 * @create 2023-03-10 1:16 AM
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name,Object value){
        this.name = name;
        this.value = value;
    }
    public String getName(){
        return name;
    }
    public Object getValue(){
        return value;
    }


}
