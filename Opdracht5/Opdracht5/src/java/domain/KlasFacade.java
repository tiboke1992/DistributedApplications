/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import entitys.Klas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stinson
 */
@Stateless
public class KlasFacade extends AbstractFacade<Klas> implements KlasFacadeRemote {
    @PersistenceContext(unitName = "Opdracht5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KlasFacade() {
        super(Klas.class);
    }
    
}
