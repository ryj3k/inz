/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databasebeans;

import databaseinterfaces.AnsweredTestFacadeLocal;
import entities.AnsweredTest;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ryj3k
 */
@Stateless
public class AnsweredTestFacade extends AbstractFacade<AnsweredTest> implements AnsweredTestFacadeLocal {
    @PersistenceContext(unitName = "Exam-System-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnsweredTestFacade() {
        super(AnsweredTest.class);
    }
    
}
