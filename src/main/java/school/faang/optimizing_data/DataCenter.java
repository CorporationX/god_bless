package school.faang.optimizing_data;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class DataCenter {
    private final List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

    public void addServer(Server server) {
        Objects.requireNonNull(server, "Server cannot be null");
        servers.add(server);
    }

    public void removeServer(Server server) {
        Objects.requireNonNull(server, "Server cannot be null");
        servers.remove(server);
    }

    public double getTotalEnergyConsumption() {
        return servers.stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }
}
