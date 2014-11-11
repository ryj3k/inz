/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseinterfaces;

import entities.Question;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ryj3k
 */
@Local
public interface QuestionFacadeLocal {

    void create(Question question);

    void edit(Question question);

    void remove(Question question);

    Question find(Object id);

    List<Question> findAll();

    List<Question> findRange(int[] range);

    int count();
    
}
