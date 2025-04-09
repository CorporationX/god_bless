package school.faang.datacenter_work_optimization.services;

import school.faang.datacenter_work_optimization.model.DataCenter;
import school.faang.datacenter_work_optimization.model.ResourceRequest;
import school.faang.datacenter_work_optimization.model.Server;

import java.util.Comparator;

public class DataCenterService {

    private void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    private void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().remove(server);
    }

    private double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getServers()
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    private boolean allocateResource(DataCenter dataCenter, ResourceRequest request) {
        double freeResources = dataCenter.getServers()
                .stream()
                .mapToDouble(server -> server.getMaxLoad() - server.getLoad())
                .sum();

        if (freeResources - request.getLoad() >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private void releaseResource(DataCenter dataCenter, ResourceRequest request) {

        do {
            dataCenter.getServers()
                    .stream()
                    .max(Comparator.comparingDouble(server -> server.getLoad()))
                    .ifPresent(server -> {
                        double load = server.getLoad();
                        double used = Math.min(load, request.getLoad());
                        request.setLoad(request.getLoad() - used);
                        server.setLoad(load - used);
                    });

        } while (request.getLoad() > 0);
    }

    public static void callOptimization(DataCenter dataCenter) {
        LoadBalancingOptimizationStrategy loadBalancingOptimizationStrategy = new LoadBalancingOptimizationStrategy();
        loadBalancingOptimizationStrategy.optimize(dataCenter);

    }
}
