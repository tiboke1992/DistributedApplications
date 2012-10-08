/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateful;






/**
 *
 * @author stinson
 */
@Stateful

public class ObjectBeanBean implements ObjectBeanRemote{
   
    @EJB
    private ControleUserInterface controle;
    private List<Persoon> lijst;
    
    public Klas geefTrosObjecten() {
        Klas klas = new Klas("Klas 1","2de verdiep",1);
        Persoon p1 = new Persoon("Hulens", "Tibo", "HULDENBERG");
        //Persoon p2 = new Persoon("Elke", "Bert", "HEVERLEE");//elke niet toegelaten
        Persoon p2 = new Persoon("El", "Bert", "HEVERLEE");
        //Persoon p3 = new Persoon("!Hulens", "Julie", "HEVERLEE");Uitroepteken geeft fout
        Persoon p3 = new Persoon("Hulens", "Julie", "HEVERLEE");
        Persoon p4 = new Persoon("Hulens", "Justine", "LEUVEN");
         lijst = new ArrayList<Persoon>();
        lijst.add(p1);
        lijst.add(p2);
        lijst.add(p3);
        lijst.add(p4);
        for(Persoon p : lijst){
            if(controle.naamIsOk(p.getNaam())){
                klas.addPersoonAanLijst(p);
                p.setKlas(klas);
            }
        }
        return klas;
    }
    
    
}
