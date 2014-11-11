/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databasebeans;

import databaseinterfaces.TestsFacadeLocal;
import entities.Tests;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ryj3k
 */
@Stateless
public class TestsFacade extends AbstractFacade<Tests> implements TestsFacadeLocal {
    @PersistenceContext(unitName = "Exam-System-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TestsFacade() {
        super(Tests.class);
    }
    
}
