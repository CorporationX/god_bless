package faang.school.godbless;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private List<Server> servers = new ArrayList<>();

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }

    public double getTotalEnergyConsumption() {
        return servers.stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public double getTotalLoad() {
        return servers.stream().mapToDouble(Server::getLoad).sum();
    }
}
