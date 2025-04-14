package school.faang.datacenter.strategy;

import school.faang.datacenter.model.DataCenter;
import school.faang.datacenter.model.Server;

public class LoadBalancingOptimizationStrategy implements  OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double summaryLoad = dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
        int count = dataCenter.getServers().size();
        double averageLoad = summaryLoad / count;
        dataCenter.getServers().stream().peek(server -> server.setLoad(averageLoad));
    }
}