package faang.school.godbless.BJS28666;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private List<Server> servers = new ArrayList<>();

    public double getTotalLoad() {
        return servers.stream().mapToDouble(Server::getLoad).sum();
    }

    public double getTotalMaxLoad() {
        return servers.stream().mapToDouble(Server::getMaxLoad).sum();
    }

    public double getTotalEnergyConsumption() {
        return servers.stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public double getTotalFreeResources() {
        return getTotalMaxLoad() - getTotalLoad();
    }
}
