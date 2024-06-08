package faang.school.godbless.intro.datacenter.strategy;

import faang.school.godbless.intro.datacenter.model.DataCenter;

public record DefaultOptimizationStrategy() implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        dataCenter
                .servers()
                .stream()
                .filter(server -> server.getMaxLoad() - server.getLoad() < 1000)
                .forEach(server -> server.scaleVertically(5000.0d));
    }
}
