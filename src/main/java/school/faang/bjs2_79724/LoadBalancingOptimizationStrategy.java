package school.faang.bjs2_79724;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double avgLoad = totalLoad / servers.size();

        for (Server server : servers) {
            server.setLoad(avgLoad);
            server.setEnergyConsumption(avgLoad * 1.5);
        }
    }
}