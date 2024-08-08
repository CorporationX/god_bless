package faang.school.godbless.DataCenter;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();

    public void addServer(Server server) {
        servers.add(server);
    }

    public void deleteServer(Server server) {
        servers.remove(server);
    }

    public Server getServerById(int id) {
        for (Server server : servers) {
            if (server.getId() == id) {
                return server;
            }
        }
        return null;
    }
}
