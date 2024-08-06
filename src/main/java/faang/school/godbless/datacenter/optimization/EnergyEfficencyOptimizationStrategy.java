package faang.school.godbless.datacenter.optimization;

import faang.school.godbless.datacenter.entities.DataCenter;
import faang.school.godbless.datacenter.entities.Server;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = dataCenter.getServers().stream()
                .mapToDouble(Server::getLoad)
                .sum();

        double maxLoad = dataCenter.getServers().stream()
                .mapToDouble(Server::getMaxLoad)
                .sum();

        var average = totalLoad / maxLoad;

        dataCenter.getServers().forEach(server ->
                server.setEnergyConsumption(server.getMaxLoad() * average)
        );
    }
}
