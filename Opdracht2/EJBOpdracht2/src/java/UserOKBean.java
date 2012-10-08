
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class UserOKBean implements ControleUserInterface {

    private List<String> namen;

    @PostConstruct
    public void beginHet() {
        namen = new ArrayList<String>();
        namen.add("Freddi");
        namen.add("Jos");
        namen.add("Elke");
    }

    @Override
    public boolean naamIsOk(String naam) {
        boolean result = false;
        if (!namen.contains(naam)) {
            result = true;
        }
        return result;
    }

    @Schedule(second = "*/5", minute = "*", hour = "*", info = "timer")
    public void controleer(javax.ejb.Timer t) {
        if(namen.size()>2){
            System.out.println("Er zijn meer dan 2 namen");
            namen.remove(0);
        }else{
            System.out.println("Genoeg plaats");
        }
    }
}
