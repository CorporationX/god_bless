package faang.school.godbless.datacenter.optimization;

import faang.school.godbless.datacenter.entities.DataCenter;
import faang.school.godbless.datacenter.entities.Server;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalConsumption = dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();

        double maxLoad = dataCenter.getServers().stream()
                .mapToDouble(Server::getMaxLoad)
                .sum();

        var average = totalConsumption / maxLoad;

        dataCenter.getServers().forEach(server ->
                server.setLoad(server.getMaxLoad() * average)
        );
    }
}
