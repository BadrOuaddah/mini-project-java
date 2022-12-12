/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Admin
 */
@Entity
public class Portefeuille {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String name;
    private double totalProfit; // total Gain et total Perde (result)
    private double totalInvestie; //total des Achats et des Ventes
    private boolean ouvert;

    public Portefeuille() {
    }

    public Portefeuille(Long id, String ref, String name, double totalProfit, double totalInvestie, boolean ouvert) {
        this.id = id;
        this.ref = ref;
        this.name = name;
        this.totalProfit = totalProfit;
        this.totalInvestie = totalInvestie;
        this.ouvert = ouvert;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public double getTotalInvestie() {
        return totalInvestie;
    }

    public void setTotalInvestie(double totalInvestie) {
        this.totalInvestie = totalInvestie;
    }

    public boolean isOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }

    @Override
    public String toString() {
        return "Portefeuille{" + "id=" + id + ", ref=" + ref + ", name=" + name + ", totalProfit=" + totalProfit + ", totalInvestie=" + totalInvestie + ", ouvert=" + ouvert + '}';
    }
    
    
}
