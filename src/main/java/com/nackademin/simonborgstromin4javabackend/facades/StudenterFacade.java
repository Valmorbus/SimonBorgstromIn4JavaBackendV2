/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.simonborgstromin4javabackend.facades;

import com.nackademin.simonborgstromin4javabackend.entities.Studenter;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author borgs_000
 */
@Stateless
public class StudenterFacade extends AbstractFacade<Studenter> {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public StudenterFacade() {
        super(Studenter.class);
    }
    
}
