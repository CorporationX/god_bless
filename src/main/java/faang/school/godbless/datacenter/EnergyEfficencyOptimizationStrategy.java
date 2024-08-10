package faang.school.godbless.datacenter;

import java.util.Comparator;
import java.util.List;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        servers.sort(Comparator.comparingDouble(Server::getEnergyConsumption));

        servers.removeIf(server -> server.getLoad() < 0);
    }
}