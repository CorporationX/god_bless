package faang.school.godbless.datacenter.strategy;

import faang.school.godbless.datacenter.model.DataCenter;

public record EnergyEfficiencyOptimizationStrategy() implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        dataCenter.servers()
                .forEach(server -> server.regulateEnergyConsumption(server.getEnergyConsumption() * 0.1));
    }
}
