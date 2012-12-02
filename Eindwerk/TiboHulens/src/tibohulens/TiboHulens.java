/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tibohulens;

import Entity.Persoon;
import Entity.PersoonFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author stinson
 */
public class TiboHulens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Context c = new InitialContext();
            PersoonFacadeLocal persoonDB = (PersoonFacadeLocal)c.lookup("java:global/TiboHulensEindwerkEJB/PersoonFacade");
            Persoon p = new Persoon();
            p.setNaam("Hulens");
            p.setAge(8);
            Persoon p1 = new Persoon();
            p1.setNaam("Hulens");
            p1.setAge(24);
            Persoon p2 = new Persoon();
            p2.setNaam("Hulens");
            p2.setAge(23);
            Persoon p3 = new Persoon();
            p3.setNaam("Hulens");
            p3.setAge(22);
            persoonDB.create(p3);
            persoonDB.create(p1);
            persoonDB.create(p2);
            persoonDB.create(p);
            System.out.println(persoonDB.quer());
            System.out.println(persoonDB.getPersoonMetLeeftijd(24));
        } catch (NamingException ex) {
            Logger.getLogger(TiboHulens.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
