package school.faang.data.center;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void deleteServer(Server server) {
        servers.remove(server);
    }
}
