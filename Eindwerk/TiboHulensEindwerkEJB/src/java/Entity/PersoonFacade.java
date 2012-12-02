/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author stinson
 */
@Stateless
public class PersoonFacade extends AbstractFacade<Persoon> implements PersoonFacadeLocal {
    @PersistenceContext(unitName = "TiboHulensEindwerkEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersoonFacade() {
        super(Persoon.class);
    }
    
    @Override
    public String quer(){
        String s = "";
        Query q = em.createQuery("SELECT p1 FROM Persoon p1 WHERE p1.age > 20");
        List<Persoon>lijst = q.getResultList();
        if(lijst.isEmpty()){
            s = "Er zijn geen personen gevonden";
        }else{
            s = "Er zijn " + lijst.size() + " Personen gevonden!";
        }
        return s;
    }

    
    public String getPersoonMetLeeftijd(int age) {
        String s;
        Query q = em.createQuery("SELECT p FROM Persoon p WHERE p.age=:waarde");
        q.setParameter("waarde", age);
        List<Persoon>lijst = q.getResultList();
        if(lijst.isEmpty()){
            s = "Er zijn geen personen gevonden";
        }else{
            s = "Er zijn " + lijst.size() + " Personen gevonden!";
        }
        return s;
    }
}
