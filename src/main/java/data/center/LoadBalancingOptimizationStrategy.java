package data.center;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    private static double OPTIMAL_PERCENT_LOAD_SERVER = 50;
    private List<ResourceRequest> requests = new ArrayList<>();

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = new ArrayList<>(dataCenter.getServerLoads().keySet());
        this.resourceRelease(servers);

        for (ResourceRequest request: this.requests) {
            servers.sort(Comparator.comparingDouble(Server::getLoad));

            for (Server server: servers) {
                if (server.loadPercent() < OPTIMAL_PERCENT_LOAD_SERVER) {
                    try {
                        server.addRequest(request);
                        break;
                    } catch (RuntimeException ignored) {}
                }
            }
        }
    }

    private void resourceRelease(List<Server> servers) {
        for (Server server : servers) {
            var serverRequests = new ArrayList<>(server.getRequestsLoad().keySet());
            for (ResourceRequest request : serverRequests) {
                server.removeRequest(request);
                this.requests.add(request);
            }
        }
    }
}
