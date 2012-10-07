
import javax.ejb.Remote;

@Remote
public interface BMIInterface {
    int berekenBMI(int gewicht, double lengte);
}
