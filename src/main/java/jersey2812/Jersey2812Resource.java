package jersey2812;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;


@Path("/test")
public class Jersey2812Resource {
    private final Set<AsyncResponse> responses = Collections.newSetFromMap(new ConcurrentHashMap<AsyncResponse, Boolean>());

    @GET
    @Path("/wait")
    public void waitForEvent(@Suspended AsyncResponse asyncResponse) {
        responses.add(asyncResponse);
    }

    @GET
    @Path("/broadcast")
    public String broadcast() {
        for (AsyncResponse response : responses) {
            response.resume("OK");
        }
        responses.clear();
        return "OK";
    }
}
