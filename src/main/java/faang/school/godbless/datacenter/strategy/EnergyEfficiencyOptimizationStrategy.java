package faang.school.godbless.datacenter.strategy;

import faang.school.godbless.datacenter.model.DataCenter;

public record EnergyEfficiencyOptimizationStrategy() implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        throw new UnsupportedOperationException();
    }
}
