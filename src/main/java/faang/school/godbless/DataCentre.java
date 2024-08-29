package faang.school.godbless;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCentre {
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


}
