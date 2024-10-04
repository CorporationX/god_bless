package school.faang.t10;

import java.util.List;

class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double averageLoad = totalLoad / servers.size();

        for (Server server : servers) {
            if (server.getLoad() > averageLoad) {
                double excess = server.getLoad() - averageLoad;
                for (Server otherServer : servers) {
                    if (otherServer.getLoad() < averageLoad) {
                        double capacity = Math.min(excess, averageLoad - otherServer.getLoad());
                        server.setLoad(server.getLoad() - capacity);
                        otherServer.setLoad(otherServer.getLoad() + capacity);
                        excess -= capacity;
                        if (excess <= 0) break;
                    }
                }
            }
        }
    }
}