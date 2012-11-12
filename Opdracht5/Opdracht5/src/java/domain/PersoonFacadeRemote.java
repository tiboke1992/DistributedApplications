/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import entitys.Persoon;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author stinson
 */
@Remote
public interface PersoonFacadeRemote {

    Object create(Persoon persoon);

    Object edit(Persoon persoon);

    void remove(Persoon persoon);

    Persoon find(Object id);

    List<Persoon> findAll();

    List<Persoon> findRange(int[] range);

    int count();
    
}
