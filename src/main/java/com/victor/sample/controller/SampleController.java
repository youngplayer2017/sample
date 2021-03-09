package com.victor.sample.controller;

import com.victor.sample.service.ISampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("sample")
public class SampleController {

    @Autowired
    ISampleService sampleService;


    @PostMapping
    public ResponseEntity<Object> readRedis(@RequestParam String method,@RequestParam String  key,@RequestParam String value) throws Exception {
        switch (method){
            case "get":
                return ResponseEntity.ok(sampleService.readRedis(key));
            case "post":
            case "put":
                return ResponseEntity.ok(sampleService.writeRedis(key,value));
            case "delete":
                return ResponseEntity.ok(sampleService.deleteRedis(key));
            default:
                throw new IllegalArgumentException("Method is not valid");
           }

    }


}
