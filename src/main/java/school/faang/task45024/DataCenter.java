package school.faang.task45024;

import lombok.Getter;

import java.util.List;

@Getter
public class DataCenter {
    private final List<Server> servers;

    public DataCenter(List<Server> servers) {
        validation(servers);

        this.servers = servers;
    }

    public void validation(List<Server> servers) {
        if (servers == null) {
            throw new IllegalArgumentException("servers is null");
        }
        for (Server server : servers) {
            if (server == null) {
                throw new IllegalArgumentException("server is null");
            }
        }
    }
}
