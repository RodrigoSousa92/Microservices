package com.bootcamp.userside.controller;

import com.bootcamp.userside.service.RequestLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestLogController {
    private final RequestLogService requestLogService;

    public RequestLogController(RequestLogService requestLogService) {
        this.requestLogService = requestLogService;
    }

    @GetMapping("/test")
    public void test(){
        requestLogService.test();
    }
}
