package faang.school.godbless.BJS2_4282;

import lombok.Getter;

import java.util.List;

@Getter
public class DataCenter {

    private List<Server> servers;

    public DataCenter(List<Server> servers) {
        validateServers(servers);
        this.servers = servers;
    }

    public void addServer(Server server) {
        validateServers(List.of(server));
        this.servers.add(server);
    }

    private void validateServers(List<Server> servers) {
        if (servers.isEmpty()) {
            throw new IllegalArgumentException("Servers not be empty");
        }
    }
}
