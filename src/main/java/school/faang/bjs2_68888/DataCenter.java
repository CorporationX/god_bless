package school.faang.bjs2_68888;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().remove(server);
    }
}
