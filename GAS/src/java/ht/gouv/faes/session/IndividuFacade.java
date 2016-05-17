/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.gouv.faes.session;

import ht.gouv.faes.entity.Individu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Benucci
 */
@Stateless
public class IndividuFacade extends AbstractFacade<Individu> {
    @PersistenceContext(unitName = "GASPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IndividuFacade() {
        super(Individu.class);
    }
    
}
