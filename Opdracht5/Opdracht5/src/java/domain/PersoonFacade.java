/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import entitys.Persoon;
import java.util.Vector;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author stinson
 */
@Stateful
public class PersoonFacade extends AbstractFacade<Persoon> implements PersoonFacadeRemote {
    @PersistenceContext(unitName = "Opdracht5PU",type= PersistenceContextType.EXTENDED)
    private EntityManager em;
    
    Vector<Persoon> personenLijst;

    @PostConstruct
    public void start(){
        personenLijst = new Vector<Persoon>();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersoonFacade() {
        super(Persoon.class);
    }
    
    public Object createPersoon(String naam, String voornaam, String klasnr){
        Persoon persoon = new Persoon();
        persoon.setNaam(naam);
        persoon.setVoornaam(voornaam);
        persoon.setKlasnr(klasnr);
        boolean exists = false;
        for(Persoon x : personenLijst){
            if((x.getNaam().equals(persoon.getNaam()) && x.getVoornaam().equals(persoon.getVoornaam()))){
                exists = true;
                break;
            }
        }
        if(exists){
            System.out.println("Deze persoon bestaat al");
        }else{
            System.out.println("Persoon bestond nog niet en is toegevoegd");
            personenLijst.add(persoon);
            em.persist(persoon);
        }
        return persoon;
    }
    
}
