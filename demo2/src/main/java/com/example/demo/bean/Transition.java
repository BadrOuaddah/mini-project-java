/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Admin
 */
@Entity
public class Transition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private char type; // Type achat(A) ou vente(V);
    private double montant;
    private double montantProfit; // achat(+) ou vente(-);
    @ManyToOne
    private Portefeuille portefeuille;
    //class Portefeuille()

    public Transition() {
    }

    public Transition(Long id, String ref, char type, double montant, double montantProfit, Portefeuille portefeuille) {
        this.id = id;
        this.ref = ref;
        this.type = type;
        this.montant = montant;
        this.montantProfit = montantProfit;
        this.portefeuille = portefeuille;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontantProfit() {
        return montantProfit;
    }

    public void setMontantProfit(double montantProfit) {
        this.montantProfit = montantProfit;
    }

    public Portefeuille getPortefeuille() {
        return portefeuille;
    }

    public void setPortefeuille(Portefeuille portefeuille) {
        this.portefeuille = portefeuille;
    }

    @Override
    public String toString() {
        return "Transition{" + "id=" + id + ", ref=" + ref + ", type=" + type + ", montant=" + montant + ", montantProfit=" + montantProfit + ", portefeuille=" + portefeuille + '}';
    }
    



    
}
