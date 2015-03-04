package jersey2812;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class ConfigJersey2812 extends Application {

    @Override
    public Set<Object> getSingletons() {
        Set<Object> singletons = new HashSet<Object>();
        singletons.add(new Jersey2812Resource());
        return singletons;
    }
}
