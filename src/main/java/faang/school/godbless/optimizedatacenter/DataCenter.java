package faang.school.godbless.optimizedatacenter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class DataCenter {
    private final List<Server> SERVERS;
    private final Map<Server, Integer> SERVER_INDEXES = new HashMap<>();

    public Server getAvailableLoadServer() {
        Server maxAvailableLoadServer = SERVERS.get(0);
        for (Server server : SERVERS) {
            if (server.getAvailableLoad() > maxAvailableLoadServer.getAvailableLoad()) {
                maxAvailableLoadServer = server;
            }
        }
        return maxAvailableLoadServer;
    }

    public Server getMaxLoadServer() {
        Server maxLoadServer = SERVERS.get(0);
        for (Server server : SERVERS) {
            if (server.getLoad() > maxLoadServer.getLoad()) {
                maxLoadServer = server;
            }
        }
        return maxLoadServer;
    }
}
