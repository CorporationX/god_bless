package faang.school.godbless.datacenter.strategy;

import faang.school.godbless.datacenter.model.DataCenter;

public class DefaultOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        dataCenter
                .servers()
                .stream()
                .filter(server -> server.getMaxLoad() - server.getLoad() < 1000)
                .forEach(server -> server.scaleVertically(5000.0d));
    }
}
