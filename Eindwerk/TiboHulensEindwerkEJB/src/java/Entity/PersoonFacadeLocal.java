/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author stinson
 */
@Remote
public interface PersoonFacadeLocal {

    void create(Persoon persoon);

    void edit(Persoon persoon);

    void remove(Persoon persoon);

    Persoon find(Object id);

    List<Persoon> findAll();

    List<Persoon> findRange(int[] range);

    int count();
    
    String quer();
    
    String getPersoonMetLeeftijd(int age);
    
}
