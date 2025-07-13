package com.project.back_end.controllers;

import java.util.Map;

import com.project.back_end.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.back_end.models.Admin;

@RestController
@RequestMapping("${api.path}" + "admin")
public class AdminController {

    private final AppService service;

    @Autowired
    public AdminController(AppService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> adminLogin(@RequestBody Admin admin)
    {
        return service.validateAdmin(admin);
    }


    @GetMapping("/dashboard/{token}")
    public String adminDashboard(@PathVariable String token)
    {
        Map<String, String> map=service.validateToken(token,"admin").getBody();
        if(map==null)
        {
            return "admin/adminDashboard";
        }
        return "redirect:http://localhost:8080/";

    }
}