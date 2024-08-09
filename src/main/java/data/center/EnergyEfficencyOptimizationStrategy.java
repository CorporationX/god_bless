package data.center;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EnergyEfficencyOptimizationStrategy implements  OptimizationStrategy {
    private List<ResourceRequest> requests = new ArrayList<>();

    @Override
    public void optimize(DataCenter dataCenter) {
        this.requests = new ArrayList<>(dataCenter.getRequestsLoaded().keySet());
        this.resourceRelease(dataCenter);
        this.requests.sort(Comparator.comparingDouble(ResourceRequest::getLoad).reversed());

        for (ResourceRequest request: this.requests) {
            List<Server> servers = dataCenter.getServers();
            servers.sort(Comparator.comparingDouble(Server::getCostPerWatt).thenComparing(Server::getCurrentEnergyConsumption));

            for (Server server: dataCenter.getServers()) {
                if (!server.allocatedLoad(request.getLoad())) {
                    continue;
                }
                dataCenter.getRequestsLoaded().put(request, server);
                break;
            }
        }
    }

    private void resourceRelease(DataCenter dataCenter) {
        for (ResourceRequest request: this.requests) {
            dataCenter.releaseResources(request);
        }
    }
}
