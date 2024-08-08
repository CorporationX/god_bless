package faang.school.godbless.data.center.optimization.strategy;

import faang.school.godbless.data.center.DataCenter;
import faang.school.godbless.data.center.Server;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {

        double totalEnergyConsumption = dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();

        double totalMaxLoad = dataCenter.getServers().stream()
                .mapToDouble(Server::getMaxLoad)
                .sum();

        double totalRelativeEnergyConsumption = totalEnergyConsumption / totalMaxLoad;

        dataCenter.getServers()
                .forEach(server -> server.setLoad(server.getMaxLoad() * totalRelativeEnergyConsumption));
    }
}
