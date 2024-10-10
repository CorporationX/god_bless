package school.faang.data.center.strategy.impl;

import school.faang.data.center.DataCenter;
import school.faang.data.center.OptimizationStrategy;
import school.faang.data.center.Server;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoadIndex = 0;
        for (Server server : servers) {
            totalLoadIndex += server.getLoadIndex();
        }
        double optimalLoadIndex = totalLoadIndex / servers.size();
        for (Server server : servers) {
            server.setLoad(server.getMaxload() * optimalLoadIndex);
        }
    }
}
