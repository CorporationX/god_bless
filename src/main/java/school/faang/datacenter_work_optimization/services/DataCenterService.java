package school.faang.datacenter_work_optimization.services;

import school.faang.datacenter_work_optimization.model.DataCenter;
import school.faang.datacenter_work_optimization.model.ResourceRequest;
import school.faang.datacenter_work_optimization.model.Server;

import java.util.Comparator;

public class DataCenterService {

    public static void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    public static void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().remove(server);
    }

    public static double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getServers()
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public static boolean allocateResource(DataCenter dataCenter, ResourceRequest request) {
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

    public static void releaseResource(DataCenter dataCenter, ResourceRequest request) {

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

    public static void printServers(DataCenter dataCenter) {
        dataCenter.getServers().forEach(server ->
                System.out.printf("Server (maxLoad=%.0f, load=%.2f, energy=%.0f, efficiency=%.2f)%n",
                        server.getMaxLoad(), server.getLoad(), server.getEnergyConsumption(), server.getEfficiency()));
    }
}
