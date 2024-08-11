package faang.school.godbless.javahashmap.task8;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class DataCenter {
    List<Server> servers = new ArrayList<>();

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }

    public List<Server> getServers() {
        return servers;
    }

    public Server getLeastLoadServer() {
        return findServerByLoad(true);
    }

    public Server getMostLoadServer() {
        return findServerByLoad(false);
    }

    public Server findServerByLoad(boolean findLeast) {
        if (servers.isEmpty()) {
            return null;
        }
        Server targetServer = servers.get(0);
        for (Server server : servers) {
            if (findLeast && targetServer.getLoad() > server.getLoad() ||
                    !findLeast && targetServer.getLoad() < server.getLoad()) {
                targetServer = server;
            }
        }
        return targetServer;
    }
}
