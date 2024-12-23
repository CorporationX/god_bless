package school.faang.sprint_1.task_45040;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {

    private final List<Server> servers = new ArrayList<>();

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }

    public double getTotalEnergyConsumption() {
        return servers.stream().mapToDouble(Server::getEnergyConsumption).sum();
    }
}
