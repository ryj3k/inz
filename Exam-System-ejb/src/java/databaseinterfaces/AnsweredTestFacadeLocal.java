/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseinterfaces;

import entities.AnsweredTest;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ryj3k
 */
@Local
public interface AnsweredTestFacadeLocal {

    void create(AnsweredTest answeredTest);

    void edit(AnsweredTest answeredTest);

    void remove(AnsweredTest answeredTest);

    AnsweredTest find(Object id);

    List<AnsweredTest> findAll();

    List<AnsweredTest> findRange(int[] range);

    int count();
    
}
