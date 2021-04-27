package com.example.springRepaso.controller;


import com.example.springRepaso.api.ApiCallService;
import com.example.springRepaso.api.ChuckNorrisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiCallService apiCallService;

    @GetMapping
    public ChuckNorrisResponse getChuck() throws IOException, InterruptedException {
        return  apiCallService.getChuckNorris();
    }

}
