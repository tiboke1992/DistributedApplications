
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

public class Klas implements Serializable {

    private String naam;
    private String plaats;
    private int lokaalNR;
    private List<Persoon> persoonLijst;
   

    public Klas() {
        this(null, null, 0);
    }

    public Klas(String naam, String plaats, int lokaalNR) {
        setNaam(naam);
        setPlaats(plaats);
        setLokaalNR(lokaalNR);
        persoonLijst = new ArrayList<Persoon>();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public int getLokaalNR() {
        return lokaalNR;
    }

    public void setLokaalNR(int lokaalNR) {
        this.lokaalNR = lokaalNR;
    }

    public void addPersoonAanLijst(Persoon p) {
        if(p.getNaam().contains("!")){
            throw new NaamFout("Er mag geen uitroepteken in je naam zitten!");
        }
             persoonLijst.add(p);
        
    }

    public void verwijderPersoon(Persoon p) {
        persoonLijst.remove(p);
    }
    @Override
    public String toString() {
        return "Klasnaam: " + naam + " Plaats: " + plaats
                + " Klasnr: " + lokaalNR + " Aantal personen :"
                + persoonLijst.size();
    }
    
    public List<Persoon> geefLijst(){
        return this.persoonLijst;
    }
}
