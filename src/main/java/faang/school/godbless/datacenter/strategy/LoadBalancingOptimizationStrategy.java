package faang.school.godbless.datacenter.strategy;

import faang.school.godbless.datacenter.model.DataCenter;

public record LoadBalancingOptimizationStrategy() implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        throw new UnsupportedOperationException();
    }
}
