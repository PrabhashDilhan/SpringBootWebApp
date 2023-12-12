package org.wso2.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wso2.sample.service.MyService;

@RestController
@RequestMapping("/api")
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/call-backend")
    public String callBackend() {
        String url = "http://localhost:8291/services/CasePutProxy"; // Replace with your backend URL
        return myService.callBackendService(url);
    }
}
