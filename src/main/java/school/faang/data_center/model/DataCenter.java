package school.faang.data_center.model;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private final List<Server> servers = new ArrayList<>();

    public void addServer(Server server) {
        servers.add(server);
    }

    public void addAllServers(Server... server) {
        servers.addAll(List.of(server));
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }

    public List<Server> getAllServers() {
        return new ArrayList<>(servers);
    }
}

