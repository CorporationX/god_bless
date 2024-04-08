package faang.school.godbless.optimizedatacenter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class DataCenter {
    private final List<Server> servers;
    private final Map<Server, Integer> serverIndexes = new HashMap<>();

    public void addServer(Server server) {
        servers.add(server);
        serverIndexes.put(server, servers.size() - 1);
    }

    public void removeServer(Server server) {
        int serverIndex = serverIndexes.get(server);
        servers.remove(serverIndex);
    }

    public Server getAvailableLoadServer() {
        Server maxAvailableLoadServer = servers.get(0);
        for (Server server : servers) {
            if (server.getAvailableLoad() > maxAvailableLoadServer.getAvailableLoad()) {
                maxAvailableLoadServer = server;
            }
        }
        return maxAvailableLoadServer;
    }

    public Server getMaxLoadServer() {
        Server maxLoadServer = servers.get(0);
        for (Server server : servers) {
            if (server.getLoad() > maxLoadServer.getLoad()) {
                maxLoadServer = server;
            }
        }
        return maxLoadServer;
    }
}
