package ru.kraiush.BJS2_33156;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double averageLoad = totalLoad / servers.size();
        for (Server server : servers) {
            server.releaseLoad(server.getLoad() - averageLoad);
        }
        System.out.println("Load balancing optimization is completed. Servers normalized to average load: " + averageLoad);
    }
}
