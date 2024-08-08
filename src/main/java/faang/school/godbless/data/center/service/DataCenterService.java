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
        double remainingLoad = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (server.getMaxLoad() - server.getLoad() > 0) {
                double availableLoad = server.getMaxLoad() - server.getLoad();
                if (availableLoad >= remainingLoad) {
                    server.setLoad(server.getLoad() + remainingLoad);
                    return true;
                } else {
                    server.setLoad(server.getMaxLoad());
                    remainingLoad -= availableLoad;
                }
            }
        }
        return false;
    }

    public boolean releaseResources(ResourceRequest request) {
        double remainingLoad = request.getLoad();

        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() > 0) {
                double availableLoad = server.getLoad();
                if (availableLoad >= remainingLoad) {
                    server.setLoad(server.getLoad() - remainingLoad);
                    return true;
                } else {
                    server.setLoad(0);
                    remainingLoad -= availableLoad;
                }
            }
        }
        return false;
    }
}
