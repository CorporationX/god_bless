package faang.school.godbless.beksultan2005;

import lombok.Getter;

import java.util.*;

@Getter
public class DataCenter {
    private List<Server> servers = new ArrayList<>();
    private HashMap<ResourceRequest, Server> resourceRequests = new HashMap<>();

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }
}
