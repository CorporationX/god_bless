package optimizing_the_work_of_the_data_center;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double averageLoad = totalLoad / servers.size();

        for (Server server : servers) {
            if (server.getLoad() > averageLoad) {
                double excessLoad = server.getLoad() - averageLoad;
                for (Server targetServer : servers) {
                    if (targetServer.getLoad() < averageLoad) {
                        double transferableLoad = Math.min(excessLoad, averageLoad - targetServer.getLoad());
                        server.releaseLoad(transferableLoad);
                        targetServer.allocateLoad(transferableLoad);
                        break;
                    }
                }
            }
        }
    }
}

