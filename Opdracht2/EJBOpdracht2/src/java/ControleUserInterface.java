
import javax.ejb.Remote;

@Remote
public interface ControleUserInterface {
    public boolean naamIsOk(String naam);
}
