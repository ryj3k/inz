/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseinterfaces;

import entities.AnsweredQuestions;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ryj3k
 */
@Local
public interface AnsweredQuestionsFacadeLocal {

    void create(AnsweredQuestions answeredQuestions);

    void edit(AnsweredQuestions answeredQuestions);

    void remove(AnsweredQuestions answeredQuestions);

    AnsweredQuestions find(Object id);

    List<AnsweredQuestions> findAll();

    List<AnsweredQuestions> findRange(int[] range);

    int count();
    
}
