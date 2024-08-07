package faang.school.godbless.DataCenter;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class DataCenter {
    private final List<Server> SERVERS = new ArrayList<>();

    public void addServer(Server server) {
        SERVERS.add(server);
    }

    public void deleteServer(Server server) {
        SERVERS.remove(server);
    }

    public Server getServerById(int id) {
        for (Server server : SERVERS) {
            if (server.getId() == id) {
                return server;
            }
        }
        return null;
    }
}
