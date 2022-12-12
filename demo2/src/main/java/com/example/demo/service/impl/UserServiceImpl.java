/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service
public class UserServiceImpl {

    @Autowired
    private UserDao userdao;

    public User findByLogin(String login) {
        return userdao.findByLogin(login);
    }

    public int deleteByLogin(String login) {
        return userdao.deleteByLogin(login);
    }

    public List<User> findByRole(String role) {
        return userdao.findByRole(role);
    }

    public int save(User user) {
        User logUser = findByLogin(user.getLogin());
        if (logUser == null) {
            return -1;
        } else {
            user.setBlock(true);
            userdao.save(user);
            return 1;
        }
    }

    public int seConnecter(User user) {
        User logUser = findByLogin(user.getLogin());
        if (logUser == null) {
            return -1;
        } else if (!user.getPassword().equals(logUser.getPassword())) {
            return -2;
        } else if (logUser.isBlock() == true) {
            return -3;
        } else {
            return 1;
        }
    }
    public int blocked(User user){
        User loadedUser = findByLogin(user.getLogin());
        if (loadedUser == null){
        return -1;
        }
        else if (loadedUser.isBlock() == true){
        return -2;
        }
        else{
           loadedUser.setBlock(true);
           userdao.save(loadedUser);
           return 1;
        }
    
    }

}
