package school.faang.datacenter;

import java.util.List;
import java.util.stream.Collectors;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = servers.stream()
                .collect(Collectors.summingDouble(Server::getLoad));
        double averageLoad = totalLoad / servers.size();

        for (Server server : servers) {
            server.setLoad(server.getLoad() - (server.getLoad() - averageLoad));
        }
    }
}