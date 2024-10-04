package school.faang.t10;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }
}
