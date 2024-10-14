package school.faang.optimizingdc;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

    // Method to add a server to the data center
    public void addServer(Server server) {
        servers.add(server);
    }

    // Method to remove a server from the data center
    public void removeServer(Server server) {
        servers.remove(server);
    }
}
