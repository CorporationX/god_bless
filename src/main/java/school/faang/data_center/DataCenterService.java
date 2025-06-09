package school.faang.data_center;

import lombok.Setter;

public class DataCenterService {
    @Setter
    private OptimizationStrategy strategy;

    public DataCenterService() {
    }

    public DataCenterService(OptimizationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean addServer(DataCenter dataCenter, Server server) {
        return dataCenter.addServer(server);
    }

    public boolean removeSever(DataCenter dataCenter, Server server) {
        return dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        double total = 0;
        for (Server server : dataCenter.getServerList()) {
            total += server.getEnergyConsumption();
        }

        return total;
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double remainingLoad = request.getLoad();
        for (Server server : dataCenter.getServerList()) {
            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (remainingLoad > 0) {
                double load = Math.min(availableLoad, remainingLoad);
                server.setLoad(server.getLoad() + load);
                remainingLoad -= load;
            }

            if (remainingLoad <= 0) {
                return true;
            }
        }

        return false;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double loadToRelease = request.getLoad();
        for (Server server : dataCenter.getServerList()) {
            double load = Math.min(server.getLoad(), loadToRelease);
            server.setLoad(server.getLoad() - load);
            loadToRelease = loadToRelease - load;

            if (loadToRelease <= 0) {
                return;
            }
        }
    }

    public void optimize(DataCenter dataCenter) {
        if (strategy == null) {
            throw new IllegalStateException("'strategy' field is not initialized");
        }
        strategy.optimize(dataCenter);
    }
}
