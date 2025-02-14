package school.faang;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double averageLoad = totalLoad / servers.size();

        for (Server server : servers) {
            double loadDifference = server.getLoad() - averageLoad;
            if (loadDifference > 0) {
                ResourceRequest releaseRequest = new ResourceRequest(loadDifference);
                new DataCenterService().releaseResources(dataCenter, releaseRequest);
                server.setLoad(server.getLoad() - loadDifference);
            } else if (loadDifference < 0) {
                ResourceRequest allocateRequest = new ResourceRequest(-loadDifference);
                new DataCenterService().allocateResources(dataCenter, allocateRequest);
                server.setLoad(server.getLoad() - loadDifference);
            }
        }
    }
}
