package faang.school.godbless.intro.datacenter.strategy;

import faang.school.godbless.intro.datacenter.model.DataCenter;

public record EnergyEfficiencyOptimizationStrategy() implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        dataCenter.servers()
                .forEach(server -> server.regulateEnergyConsumption(server.getEnergyConsumption() * 0.1));
    }
}
