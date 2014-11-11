/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databasebeans;

import databaseinterfaces.AnsweredAnswersFacadeLocal;
import entities.AnsweredAnswers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ryj3k
 */
@Stateless
public class AnsweredAnswersFacade extends AbstractFacade<AnsweredAnswers> implements AnsweredAnswersFacadeLocal {
    @PersistenceContext(unitName = "Exam-System-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnsweredAnswersFacade() {
        super(AnsweredAnswers.class);
    }
    
}
