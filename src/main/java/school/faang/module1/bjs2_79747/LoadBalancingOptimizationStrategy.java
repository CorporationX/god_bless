package school.faang.module1.bjs2_79747;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy{

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        if (servers == null || servers.isEmpty()) {
            return;
        }
        double totalLoad = servers.stream()
                .mapToDouble(Server::getLoad)
                .sum();
        double averageLoad = totalLoad / servers.size();
        for (Server server : servers) {
            server.setLoad(Math.min(averageLoad, server.getMaxLoad()));
        }
    }
}