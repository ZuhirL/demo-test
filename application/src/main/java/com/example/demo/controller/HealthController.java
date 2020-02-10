package com.example.demo.controller;

import com.example.demo.bean.response.HealthBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/health")
public class HealthController {

    @Value("${version}")
    private String projectVersion;

    @GetMapping(value = { "", "/" })
    public ResponseEntity<?> home() {
        HealthBean healthBean = new HealthBean();
        healthBean.setMessage("Welcome, the Example Test is running.");
        healthBean.setDateTime(new Date());
        healthBean.setProjectVersion(this.projectVersion);

        return new ResponseEntity(healthBean, HttpStatus.OK);
    }
}
