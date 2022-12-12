/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.bean.Commande;
import com.example.demo.dao.CommandeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Service
public class CommandeServiceImpl {

    @Autowired
    private CommandeDao commandeDao;

    public int save(Commande commande) {
        if (findByReference(commande.getReference()) != null) {
            return -1;
        } else if (commande.getTotalPaye() > commande.getTotal()) {
            return -2;
        } else {
            commandeDao.save(commande);
            return 1;
        }
    }

    public int payer(String ref, double montant) {
        Commande commande = findByReference(ref);
        if (commande == null || commande.getId() == null) {
            return -1;
        } else if (commande.getTotalPaye() + montant > commande.getTotal()) {
            return -2;
        } else {
            double nvTotalPaye = commande.getTotalPaye() + montant;
            commande.setTotalPaye(nvTotalPaye);
            commandeDao.save(commande);
            return 1;
        }
    }

    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    public Commande findByTotalLessThan(double total) {
        return commandeDao.findByTotalLessThan(total);
    }

    @Transactional
    public int deleteByReference(String reference) {
        return commandeDao.deleteByReference(reference);
    }

}
