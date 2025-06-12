package school.faang.bjs2_79724;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {

    private final List<Server> servers = new ArrayList<>();

    public boolean addServer(Server server) {
        if (!servers.contains(server)) {
            servers.add(server);
            return true;
        }
        return false;
    }

    public boolean removeServer(Server server) {
        return servers.remove(server);
    }

    public List<Server> getServers() {
        return new ArrayList<>(servers);
    }
}
