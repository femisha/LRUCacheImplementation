package com.licious.cache.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CacheRepository {

    Map<String, String> cache = new HashMap<>();
    //take anu elem put in 1 ,DEL IN LAST
    LinkedList<String> list = new LinkedList<>();

    public  void save(String key, String value){
        cache.put(key, value);
        list.addFirst(key);
        System.out.println("lIST VALUE: " +list.toString());
        System.out.println("CACHE : " +cache.toString());

    }

    public int getSize(){
        return cache.size();
    }

    public List<String> getList(){
        return list;
    }

    public void removeFromLast(String key){
        list.removeLast();
        cache.remove(key);
    }

    public String getFromLast(){
        return list.getLast();
    }

    public String getFromCache(String key){
        String value= cache.get(key);

        if(list.contains(key)){
            list.remove(key);
            list.addFirst(key);
        }
        System.out.println("lIST VALUE: " +list.toString());
        System.out.println("CACHE : " +cache.toString());
        return  value;
    }
}
