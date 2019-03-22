package com.chen.book.entity;

import java.util.HashMap;
import java.util.Map;

public class ViewObj {
    private Map<String,Object> map=new HashMap<>();
    public void set(String key,Object o){
        map.put(key,o);
    }
    public void get(String key,Object o){
        map.get(key);
    }
}
