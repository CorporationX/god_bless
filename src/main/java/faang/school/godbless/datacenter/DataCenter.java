package faang.school.godbless.datacenter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private final static int MAX_SERVERS = 50;
    private final List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>(MAX_SERVERS);
    }

    public void addServer(Server server) {
        this.servers.add(server);
    }

    public void removeServer(Server server) {
        this.servers.remove(server);
    }

    public double getTotalEnergyConsumption() {
        return this.servers.stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }
}