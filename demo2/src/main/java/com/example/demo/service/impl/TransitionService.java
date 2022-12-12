/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.bean.Portefeuille;
import com.example.demo.bean.Transition;
import com.example.demo.dao.PorteFeuilleDao;
import com.example.demo.dao.TransitionDao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TransitionService {

    @Autowired
    private TransitionDao transitionDao;

    @Autowired
    private PorteFeuilleService porteFeuilleService;

    public int operation(Transition transition, Portefeuille portefeuille) {

        if (transition.getType() == 'A') {
            double nvMtProfit = transition.getMontantProfit() + portefeuille.getTotalInvestie();
            transition.setMontantProfit(nvMtProfit);

        } else if (transition.getType() == 'V') {
            double nvMtProfit = transition.getMontantProfit() - portefeuille.getTotalInvestie();
            transition.setMontantProfit(nvMtProfit);

        }
        return 0;
    }

    public int montant(Portefeuille portefeuille, double montant) {
        if (portefeuille.isOuvert() == false) {
            return -1;
        } else if (montant < 0) {
            return -2;
        } else {
//            double nvMontant = portefeuille.getTotalProfit() + montant;
//            portefeuille.setTotalProfit(nvMontant);
        }
        return 0;
    }

    public int save(Transition transition) {
        Portefeuille portefeuille = porteFeuilleService.finByRef(transition.getPortefeuille().getRef());
        portefeuille.setTotalProfit(portefeuille.getTotalProfit() + transition.getMontant());
        transitionDao.save(transition);
        porteFeuilleService.update(portefeuille);
        return 1;
    }

}
