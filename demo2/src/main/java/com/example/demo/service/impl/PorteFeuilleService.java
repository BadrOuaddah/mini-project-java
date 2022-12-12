/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.bean.Portefeuille;
import com.example.demo.dao.PorteFeuilleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class PorteFeuilleService {
    
    @Autowired
    private PorteFeuilleDao porteFeuilleDao;

    public void update(Portefeuille portefeuille){
        porteFeuilleDao.save(portefeuille);
    }
    public Portefeuille finByRef(String ref) {
        return porteFeuilleDao.finByRef(ref);
    }
    
}
