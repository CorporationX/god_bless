package school.faang.optimizingdc;

import java.util.List;

public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        this.dataCenter = dataCenter;
        this.optimizationStrategy = optimizationStrategy;
    }

    // Method to add a server to the data center
    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    // Method to remove a server from the data center
    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    // Method to get total energy consumption of all servers
    public double getTotalEnergyConsumption() {
        double totalEnergy = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergy += server.getEnergyConsumption();
        }
        return totalEnergy;
    }

    // Method to allocate resources to a server based on the resource request
    public boolean allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.canAllocate(request.getLoad())) {
                server.allocateLoad(request.getLoad());
                return true;
            }
        }
        return false; // No available server found
    }

    // Method to release resources from a server based on the resource request
    public void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            server.releaseLoad(request.getLoad());
        }
    }

    // Method to optimize data center using the provided strategy
    public void optimizeDataCenter() {
        optimizationStrategy.optimize(dataCenter);
    }
}

