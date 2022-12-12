/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.ws;

import com.example.demo.bean.Commande;
import com.example.demo.service.impl.CommandeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ali
 */
@RestController
@RequestMapping("/api/commande")
public class CommadeRest {

    @Autowired
    private CommandeServiceImpl commandeServiceImpl;

    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        return commandeServiceImpl.save(commande);
    }

    @PutMapping("/payer/ref/{ref}/mt/{montant}")
    public int payer(@PathVariable String ref, @PathVariable double montant) {
        return commandeServiceImpl.payer(ref, montant);
    }
    @GetMapping("/ref/{reference}")
    public Commande findByReference(@PathVariable String reference) {
        return commandeServiceImpl.findByReference(reference);
    }
    @GetMapping("/total/{total}")
    public Commande findByTotalLessThan(double total) {
        return commandeServiceImpl.findByTotalLessThan(total);
    }
    @DeleteMapping("/ref/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return commandeServiceImpl.deleteByReference(reference);
    }
}
