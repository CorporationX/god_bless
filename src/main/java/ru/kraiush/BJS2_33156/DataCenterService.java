package ru.kraiush.BJS2_33156;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DataCenterService {
    private final OptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();
    private DataCenter dataCenter;

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void deleteServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(ResourceRequest request) {
        List<Server> servers = dataCenter.getServers();
        double requestLoad = request.getLoad();
        double totalAvailableLoad = getTotalAvailableLoad();
        if (requestLoad > totalAvailableLoad) {
            double maxLoadForNewServer = requestLoad - totalAvailableLoad;
            addServer(new Server(maxLoadForNewServer));
        }
        while (requestLoad > 0) {
            for (Server server : servers) {
                double availableServerLoad = server.getMaxLoad() - server.getLoad();
                if (requestLoad <= availableServerLoad) {
                    server.allocateLoad(requestLoad);
                    requestLoad = 0;
                } else {
                    server.allocateLoad(availableServerLoad);
                    requestLoad -= availableServerLoad;
                }
            }
        }
        System.out.println("Request was successfully allocated: " + request);
    }

    public void releaseResources(ResourceRequest request) {
        List<Server> servers = dataCenter.getServers();
        double requestLoad = request.getLoad();
        while (requestLoad > 0) {
            for (Server server : servers) {
                double busyLoad = server.getLoad();
                if (requestLoad <= busyLoad) {
                    server.releaseLoad(requestLoad);
                    requestLoad = 0;
                } else {
                    server.releaseLoad(busyLoad);
                    requestLoad -= busyLoad;
                }
            }
        }
        System.out.println("Resource was successfully released: " + request);
    }

    public void getDataCenterInfo() {
        System.out.println(dataCenter);
    }

    public void optimizeDataCenter() {
        strategy.optimize(dataCenter);
    }

    private double getTotalAvailableLoad() {
        double totalMaxLoad = dataCenter.getServers().stream().mapToDouble(Server::getMaxLoad).sum();
        double totalLoad = dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
        return totalMaxLoad - totalLoad;
    }
}
