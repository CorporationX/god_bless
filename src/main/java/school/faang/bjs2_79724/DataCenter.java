package school.faang.bjs2_79724;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {

    private final List<Server> servers = new ArrayList<>();

    public void addServer(Server server) {
        if (!servers.contains(server)) {
            servers.add(server);
        }
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }
}
