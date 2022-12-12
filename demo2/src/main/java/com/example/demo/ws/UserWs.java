/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.ws;

import com.example.demo.bean.User;
import com.example.demo.service.impl.UserServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api/v1/user")

public class UserWs {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/login/(login)")
    public User findByLogin(@PathVariable String login) {
        return userServiceImpl.findByLogin(login);
    }

    
    @DeleteMapping("/login/(login)")
    public int deleteByLogin(@PathVariable String login) {
        return userServiceImpl.deleteByLogin(login);
    }

    @GetMapping("/role/(role)")
    public List<User> findByRole(@PathVariable String role) {
        return userServiceImpl.findByRole(role);
    }
    

    @PostMapping("/")
    public int save(@RequestBody User user) {
        return userServiceImpl.save(user);
    }

    @GetMapping("/")
    public int seConnecter(@RequestBody User user) {
        return userServiceImpl.seConnecter(user);
    }
    
}
