package com.bit.connect.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","刘义");
        map.put("age","18");
        map.put("sex","male");

        //从map中取数据，如何取出全部
 //       String name= map.get("name");
 //       System.out.println(name);
        Set<String>keys =map.keySet();
        for (String key:keys){
            System.out.println(key);
            String value=map.get(key);
            System.out.println(value);
        }
    }
}
