package com.licious.cache.service;

import com.licious.cache.repository.CacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheService {

    @Autowired
    private CacheRepository cacheRepository;

     int size=3;
    public String addData(String key, String value) {
         int len=cacheRepository.getSize();
         List<String> list=cacheRepository.getList();
         if(len==3){
             String lastElemKey=cacheRepository.getFromLast();
             cacheRepository.removeFromLast(lastElemKey);
         }

        cacheRepository.save(key,value);

        return "Data added";
    }

    public String getData(String key) {
        return cacheRepository.getFromCache(key);
    }
}
