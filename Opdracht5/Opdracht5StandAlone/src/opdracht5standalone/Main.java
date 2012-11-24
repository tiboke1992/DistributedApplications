/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht5standalone;

import domain.KlasFacadeRemote;
import domain.PersoonFacadeRemote;
import entitys.Klas;
import entitys.Persoon;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author stinson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Context c = new InitialContext();
            PersoonFacadeRemote persoonDB = (PersoonFacadeRemote) c.lookup("java:global/Opdracht5/PersoonFacade!domain.PersoonFacadeRemote");
            KlasFacadeRemote klasDB = (KlasFacadeRemote) c.lookup("java:global/Opdracht5/KlasFacade!domain.KlasFacadeRemote");
            Persoon p1 = new Persoon();
            p1.setKlasnr("klas");
            p1.setNaam("Vermeulen");
            p1.setVoornaam("Joske");
            Persoon p2 = new Persoon();
            p2.setKlasnr("klas");
            p2.setNaam("Hulens");
            p2.setVoornaam("Tibo");
            Klas klas = new Klas();
            klas.setKlasNR("DitisDeklasNr");
            klas.setKlasNaam("Klas voor speciale kinderen");
            klas = (Klas) klasDB.create(klas);
            p1 = (Persoon) persoonDB.create(p1);
            p2 = (Persoon) persoonDB.create(p2);
            p1.setKlas(klas);
            p2.setKlas(klas);
            persoonDB.edit(p1);
            persoonDB.edit(p2);
            List<Persoon> lijst = new ArrayList<Persoon>();
            lijst.add(p1);
            lijst.add(p2);
            klas.setKlasLijst(lijst);
            klasDB.edit(klas);

            Klas klas2 = new Klas();
            klas2.setKlasNR("blabla");
            klas2.setKlasNaam("klas opt terras");
            klas2 = (Klas) klasDB.create(klas2);

            Persoon p3 = new Persoon();
            p3.setKlasnr("chacha");
            p3.setNaam("test");
            p3.setVoornaam("Tester de");
            p3 = (Persoon) persoonDB.create(p3);
            p3.setKlas(klas2);
            p3 = (Persoon) persoonDB.edit(p3);

            List<Persoon> l2 = new ArrayList<Persoon>();
            l2.add(p3);
            klas2.setKlasLijst(l2);
            klas2 = (Klas) klasDB.edit(klas2);
            List<Persoon> personenLijst = persoonDB.findAll();
            for (Persoon p : personenLijst) {
                System.out.println(p.toString());
            }
            /////generate lazy error
            List<Klas> klasLijst = klasDB.findAll();
            for (Klas k : klasLijst) {
                System.out.println("Klasnaam = " + k.getKlasNaam());
                List<Persoon> l = k.getKlasLijst();
                for (Persoon p : l) {
                    System.out.println("Persoon in klas : " + k.getKlasNaam() + " ++ Naam = " + p.getVoornaam() + " " + p.getNaam());
                }
            }
            System.out.println("---------------Merge testen:---------------------");
            p3.setNaam("Nieuwe naam van p3");
            p3.getKlas().setKlasNaam("Veranderde naam van de klas");
            p3 = (Persoon) persoonDB.edit(p3);
            Persoon ll = persoonDB.find(p3.getId());
            System.out.println(ll.getNaam() + "  " + ll.getKlas().getKlasNaam());
            System.out.println("---------------Einde merge test-------------------");
            System.out.println("---------------Remove testen:---------------------");
            //error genereren voor remove
            //  klasDB.remove(p3.getKlas());
            //oplossen
            Klas kkkk = p3.getKlas();
            p3.setKlas(null);
            p3 = (Persoon) persoonDB.edit(p3);
            klasDB.remove(kkkk);
            System.out.println("---------------Einde Remove testen:---------------------");
            System.out.println("---------------Extended entity manager testen:---------------------");
            persoonDB.createPersoon("a", "b", "c");
            persoonDB.createPersoon("a", "b", "c");
            persoonDB.createPersoon("a", "b", "c");
             System.out.println("---------------Einde Extended entity manager testen:---------------------");
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
