package optimise;

import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

@Getter
public class DataCenter {

    private final List<Server> servers = new ArrayList<>();

    protected void addServer(Server server){
        servers.add(server);
    }

    protected void removeServer(Server server){
        servers.remove(server);
    }
}
