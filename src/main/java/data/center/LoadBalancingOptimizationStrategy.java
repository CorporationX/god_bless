package data.center;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    private static double OPTIMAL_PERCENT_LOAD_SERVER = 50;
    private List<ResourceRequest> requests = new ArrayList<>();

    @Override
    public void optimize(DataCenter dataCenter) {
        this.requests = new ArrayList<>(dataCenter.getRequestsLoaded().keySet());
        this.resourceRelease(dataCenter);

        for (ResourceRequest request: this.requests) {
            List<Server> servers = dataCenter.getServers();
            servers.sort(Comparator.comparingDouble(Server::getLoad).thenComparing(Server::getCostPerLoad));

            for (Server server: dataCenter.getServers()) {
                if (server.loadPercent() < OPTIMAL_PERCENT_LOAD_SERVER) {
                    if (!server.allocatedLoad(request.getLoad())) {
                        continue;
                    }
                    dataCenter.getRequestsLoaded().put(request, server);
                    break;
                }
            }
        }
    }

    private void resourceRelease(DataCenter dataCenter) {
        for (ResourceRequest request: this.requests) {
            dataCenter.releaseResources(request);
        }
    }
}
