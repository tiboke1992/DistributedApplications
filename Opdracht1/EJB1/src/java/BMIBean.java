
import javax.ejb.Stateless;

@Stateless
public class BMIBean implements BMIInterface {

    @Override
    public int berekenBMI(int gewicht, double lengte) {
       return (int) (gewicht/(lengte*lengte));
    }
}
