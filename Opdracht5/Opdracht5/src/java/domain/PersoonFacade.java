/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import entitys.Persoon;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stinson
 */
@Stateless
public class PersoonFacade extends AbstractFacade<Persoon> implements PersoonFacadeRemote {
    @PersistenceContext(unitName = "Opdracht5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersoonFacade() {
        super(Persoon.class);
    }
    
}
