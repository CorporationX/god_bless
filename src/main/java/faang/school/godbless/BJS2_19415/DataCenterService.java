package faang.school.godbless.BJS2_19415;

import faang.school.godbless.BJS2_19415.OptimizationStrategy.OptimizationStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class DataCenterService {
    @Getter
    private DataCenter dataCenter;

    public void addServer(Server server) {
        dataCenter.getCluster().add(server);
    }

    public void removeServer(Server server) {
        List<Server> cluster = dataCenter.getCluster();
        if(cluster.contains(server)) {
            cluster.remove(server);
        } else {
            throw new IllegalArgumentException("The server is absent in cluster");
        }

    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.0;
        for (Server server : dataCenter.getCluster()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public double getTotalLoad() {
        double totalLoad = 0.0;
        for (Server server : dataCenter.getCluster()) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    public double getTotalFreeLoad() {
        double totalFreeLoad = 0.0;
        for (Server server : dataCenter.getCluster()) {
            totalFreeLoad += server.getMaxLoad() - server.getLoad();
        }
        return totalFreeLoad;
    }

    private void checkAllocateResourcesLoad(double load) {
        if (load > getTotalFreeLoad()) {
            throw new IllegalArgumentException("The amount of resources allocated exceeds the amount of unused cluster load");
        }
    }

    private void checkReleaseResourcesLoad(double load) {
        if (load > getTotalLoad()) {
            throw new IllegalArgumentException("The number of resources being released exceeds the amount of current cluster load");
        }
    }

    public void allocateResources(ResourceRequest request) {
        double requestLoadValue = request.getLoad();
        checkAllocateResourcesLoad(requestLoadValue);
        for (Server server : dataCenter.getCluster()) {
            if (requestLoadValue - (server.getMaxLoad() - server.getLoad()) <= 0.0) {
                server.setLoad(server.getLoad() + requestLoadValue);
                break;
            } else {
                server.setLoadToMaxValue();
                requestLoadValue -= server.getLoad();
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        double requestsLoadValue = request.getLoad();
        checkReleaseResourcesLoad(requestsLoadValue);
        for (Server server : dataCenter.getCluster()) {
            if (requestsLoadValue - server.getLoad() <= 0.0) {
                server.setLoad(server.getLoad() - requestsLoadValue);
                break;
            } else {
                server.setLoadToMinValue();
                requestsLoadValue -= server.getMaxLoad();
            }
        }
    }

    public void optimizeCluster(OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }

    public void viewCluster() {
        dataCenter.getCluster().forEach(System.out::println);
        System.out.println();
    }
}
