package data.center;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EnergyEfficencyOptimizationStrategy implements  OptimizationStrategy {
    private List<ResourceRequest> requests = new ArrayList<>();

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = new ArrayList<>(dataCenter.getServerLoads().keySet());
        this.resourceRelease(servers);
        this.requests.sort(Comparator.comparingDouble(ResourceRequest::getLoad).reversed());

        for (ResourceRequest request: this.requests) {
            servers.sort(Comparator.comparingDouble(Server::getEnergyConsumption).thenComparing(Server::getLoad).reversed());

            for (Server server: servers) {
                try {
                    server.addRequest(request);
                    break;
                } catch (RuntimeException ignored) {}
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
