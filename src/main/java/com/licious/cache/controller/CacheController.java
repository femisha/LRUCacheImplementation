package com.licious.cache.controller;

import com.licious.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @PostMapping("/addData")

    public String addValue(@RequestParam  String key, @RequestParam String value){
        return cacheService.addData(key,value);
    }

    @GetMapping("/getData/{key}")

    public String getValue(@PathVariable String key){
        return cacheService.getData(key);
    }
}
