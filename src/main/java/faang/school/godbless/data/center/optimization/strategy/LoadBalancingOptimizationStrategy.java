package faang.school.godbless.data.center.optimization.strategy;

import faang.school.godbless.data.center.DataCenter;
import faang.school.godbless.data.center.Server;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {

        double totalLoad = dataCenter.getServers().stream()
                .mapToDouble(Server::getLoad)
                .sum();

        double totalMaxLoad = dataCenter.getServers().stream()
                .mapToDouble(Server::getMaxLoad)
                .sum();

        double totalRelativeLoad = totalLoad / totalMaxLoad;

        dataCenter.getServers()
                .forEach(server -> server.setLoad(server.getMaxLoad() * totalRelativeLoad));
    }
}
