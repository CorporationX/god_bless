package data.optimization.optim.strategy;

import data.optimization.DataCenter;
import data.optimization.ResourceRequest;
import data.optimization.Server;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SillyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<ResourceRequest> requests = new ArrayList<>();
        List<Server> servers = new ArrayList<>(dataCenter.getServerLoadsMap().keySet());
        servers.forEach(server -> requests.addAll(server.getRequestsLoad().keySet()));
        for (Server server : servers) {
            var serverRequests = new ArrayList<>(server.getRequestsLoad().keySet());
            for (ResourceRequest request : serverRequests) {
                server.removeRequest(request);
            }
        }
        servers.sort(Comparator.comparingDouble(Server::getMaxLoad).reversed());
        requests.sort(Comparator.comparingDouble(ResourceRequest::getLoad).reversed());
        for (ResourceRequest request : requests) {
            for (Server server : servers) {
                if (server.getAvailableLoad() >= request.getLoad()) {
                    server.addRequest(request);
                    break;
                }
            }
        }
    }
}
