package faang.school.godbless.data.center;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {

    private List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

    public List<Server> getServers() {
        return servers;
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }

}
