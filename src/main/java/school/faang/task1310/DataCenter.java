package school.faang.task1310;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {

    private List<Server> allServers = new ArrayList<>();

    public void addServer(Server server) {
        allServers.add(server);
    }

    public void removeServer(Server server) {
        allServers.remove(server);
    }

    public List<Server> getAllServers() {
        return allServers;
    }
}
