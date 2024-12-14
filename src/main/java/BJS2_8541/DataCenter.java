package BJS2_8541;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class DataCenter {
    private List<Server> servers;
    private String name;


    public void addServer(Server server) {
        servers.add(server);
    }
    public void removeServer(Server server) {
        servers.remove(server);
    }
}
