package school.faang.data_center;

public class DataCenterService {
    public boolean addServer(DataCenter dataCenter, Server server) {
        return dataCenter.getServerList().add(server);
    }

    public boolean removeSever(DataCenter dataCenter, Server server) {
        return dataCenter.getServerList().remove(server);
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

    public void optimize(DataCenter dataCenter, OptimizationStrategy strategy) {
        if (strategy != null) {
            strategy.optimize(dataCenter);
        }
    }
}
