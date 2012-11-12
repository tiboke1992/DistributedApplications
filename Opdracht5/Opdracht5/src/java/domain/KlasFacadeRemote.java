
package domain;

import entitys.Klas;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface KlasFacadeRemote {

    Object create(Klas klas);

    Object edit(Klas klas);

    void remove(Klas klas);

    Klas find(Object id);

    List<Klas> findAll();

    List<Klas> findRange(int[] range);

    int count();
    
}
