package faang.school.godbless.task_13;

import faang.school.godbless.task_13.optimization.OptimizationStrategy;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class DataCenterService {
    private final DataCenter dataCenter;

    public void addServer(Server server) {
        if (server == null) {
            return;
        }
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        if (server == null || dataCenter.isEmpty()) {
            return;
        }
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public boolean allocateResources(ResourceRequest request) {
        if (dataCenter.isEmpty()) {
            return false;
        }

        double requestLoad = request.getLoad();
        Server maxAvailableLoadServer = findMaxServer(Comparator.comparing(Server::getAvailableLoad));

        if (maxAvailableLoadServer.getAvailableLoad() < requestLoad) {
            return false;
        }

        maxAvailableLoadServer.setLoad(maxAvailableLoadServer.getLoad() + requestLoad);
        return true;
    }

    public boolean releaseResources(ResourceRequest request) {
        if (dataCenter.isEmpty()) {
            return false;
        }

        double requestLoad = request.getLoad();
        Server maxLoadServer = findMaxServer(Comparator.comparing(Server::getLoad));

        if (maxLoadServer.getLoad() < requestLoad) {
            maxLoadServer.setLoad(0);
        } else {
            maxLoadServer.setLoad(maxLoadServer.getLoad() - requestLoad);
        }
        return true;
    }

    private Server findMaxServer(Comparator<Server> comparator) {
        Server maxLoadServer = dataCenter.getServers().get(0);
        for (Server server : dataCenter.getServers()) {
            if (comparator.compare(server, maxLoadServer) > 0) {
                maxLoadServer = server;
            }
        }
        return maxLoadServer;
    }

    public List<Server> getAllServers() {
        return dataCenter.getServers();
    }

    public void optimize(OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }
}
