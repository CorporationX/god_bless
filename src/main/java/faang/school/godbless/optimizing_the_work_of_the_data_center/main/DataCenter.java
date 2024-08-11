package faang.school.godbless.optimizing_the_work_of_the_data_center.main;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DataCenter {
    private List<Server> servers;

    public DataCenter(List<Server> servers) {
        if (servers == null) {
            throw new IllegalArgumentException("Servers cannot be null");
        }
        if (servers.isEmpty()) {
            throw new IllegalArgumentException("Servers cannot be empty");
        }
        this.servers = servers;
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }
}
