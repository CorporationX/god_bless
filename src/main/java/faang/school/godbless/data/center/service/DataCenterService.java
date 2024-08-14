package faang.school.godbless.data.center.service;

import faang.school.godbless.data.center.DataCenter;
import faang.school.godbless.data.center.Server;
import faang.school.godbless.data.center.optimization.strategy.OptimizationStrategy;
import faang.school.godbless.data.center.request.ResourceRequest;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class DataCenterService {

    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public void optimize() {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        }
    }

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public boolean allocateResources(ResourceRequest request) {
        double requestedLoad = request.getLoad();
        double totalAvailableResources = dataCenter.getServers().stream()
                .mapToDouble(server -> server.getMaxLoad() - server.getLoad())
                .sum();

        if (totalAvailableResources < requestedLoad) {
            return false;
        }

        for (Server server : dataCenter.getServers()) {
            if (server.getMaxLoad() - server.getLoad() > 0) {
                double availableLoad = server.getMaxLoad() - server.getLoad();
                if (availableLoad >= requestedLoad) {
                    server.setLoad(server.getLoad() + requestedLoad);
                    return true;
                } else {
                    server.setLoad(server.getMaxLoad());
                    requestedLoad -= availableLoad;
                }
            }
        }
        return false;
    }

    public boolean releaseResources(ResourceRequest request) {
        double requestedForRelease = request.getLoad();
        double totalCurrentLoad = dataCenter.getServers().stream()
                .mapToDouble(Server::getLoad)
                .sum();

        if (totalCurrentLoad < requestedForRelease) {
            return false;
        }

        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() > 0) {
                double currentLoad = server.getLoad();
                if (currentLoad >= requestedForRelease) {
                    server.setLoad(server.getLoad() - requestedForRelease);
                    return true;
                } else {
                    server.setLoad(0);
                    requestedForRelease -= currentLoad;
                }
            }
        }
        return false;
    }
}
