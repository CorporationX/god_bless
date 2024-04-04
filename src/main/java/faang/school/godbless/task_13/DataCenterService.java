package faang.school.godbless.task_13;

import faang.school.godbless.task_13.optimization.OptimizationStrategy;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DataCenterService {
    private final DataCenter dataCenter;

    public void addServer(Server server) {
        if (server == null) {
            return;
        }
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        if (server == null || dataCenter.getServers().isEmpty()) {
            return;
        }
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public boolean allocateResources(ResourceRequest request) {
        if (dataCenter.getServers().isEmpty()) {
            return false;
        }

        double requestLoad = request.getLoad();
        Server maxAvailableLoadServer = dataCenter.getServers().get(0);
        for (Server server : dataCenter.getServers()) {
            if (server.getAvailableLoad() > maxAvailableLoadServer.getAvailableLoad()) {
                maxAvailableLoadServer = server;
            }
        }

        if (maxAvailableLoadServer.getAvailableLoad() < requestLoad) {
            return false;
        }

        maxAvailableLoadServer.setLoad(maxAvailableLoadServer.getLoad() + requestLoad);
        return true;
    }

    public boolean releaseResources(ResourceRequest request) {
        if (dataCenter.getServers().isEmpty()) {
            return false;
        }

        double requestLoad = request.getLoad();
        Server maxLoadServer = dataCenter.getServers().get(0);
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() > maxLoadServer.getLoad()) {
                maxLoadServer = server;
            }
        }

        if (maxLoadServer.getLoad() < requestLoad) {
            return false;
        }

        maxLoadServer.setLoad(maxLoadServer.getLoad() - requestLoad);
        return true;
    }

    public List<Server> getAllServers() {
        return dataCenter.getServers();
    }

    public void optimize(OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }
}
