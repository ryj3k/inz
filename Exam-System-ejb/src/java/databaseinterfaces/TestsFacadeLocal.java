/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseinterfaces;

import entities.Tests;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ryj3k
 */
@Local
public interface TestsFacadeLocal {

    void create(Tests tests);

    void edit(Tests tests);

    void remove(Tests tests);

    Tests find(Object id);

    List<Tests> findAll();

    List<Tests> findRange(int[] range);

    int count();
    
}
