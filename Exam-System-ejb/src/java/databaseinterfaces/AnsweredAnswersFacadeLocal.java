/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseinterfaces;

import entities.AnsweredAnswers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ryj3k
 */
@Local
public interface AnsweredAnswersFacadeLocal {

    void create(AnsweredAnswers answeredAnswers);

    void edit(AnsweredAnswers answeredAnswers);

    void remove(AnsweredAnswers answeredAnswers);

    AnsweredAnswers find(Object id);

    List<AnsweredAnswers> findAll();

    List<AnsweredAnswers> findRange(int[] range);

    int count();
    
}
