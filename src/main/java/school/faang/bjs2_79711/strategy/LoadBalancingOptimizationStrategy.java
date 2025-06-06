package school.faang.bjs2_79711.strategy;

import school.faang.bjs2_79711.DataCenter;
import school.faang.bjs2_79711.Server;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = servers.stream().mapToDouble((Server::getLoad)).sum();
        double averageLoad = totalLoad / servers.size();

        servers.forEach(server -> server.setLoad(averageLoad));
    }
}
