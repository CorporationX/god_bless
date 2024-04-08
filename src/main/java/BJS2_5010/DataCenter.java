package BJS2_5010;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class DataCenter {
    private List<Server> servers = new ArrayList<>();

    public static Server findLowLoadServer(List<Server> servers, ResourceRequest request) {
        double lowLoadServer = 0;
        Server availableServer = null;
        for (Server server : servers) {
            if (server.getLoad() + request.getLoad() <= server.getMaxLoad()) {
                if (lowLoadServer <= server.getLoad()) {
                    availableServer = server;
                    lowLoadServer = server.getLoad();
                }
            }
        }
        return availableServer;
    }
}
