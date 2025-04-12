package school.faang.datacenter.strategy;

import school.faang.datacenter.model.DataCenter;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        dataCenter.getServers().stream()
                .filter(server -> server.getLoad() == 0)
                .forEach(server -> server.setEnergyConsumption(0));
    }
}