package school.faang.sprint_1.task_45026.repository;

import school.faang.sprint_1.task_45026.entity.Server;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private final List<Server> servers = new ArrayList<>();

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }

    public List<Server> getServers() {
        return List.copyOf(servers);
    }
}
