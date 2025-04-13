package optimizingdatacenter;

public class DataCenterService {

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double remainingLoad = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (availableLoad >= 0) {
                double loadToAllocate = Math.min(availableLoad, remainingLoad);
                server.setLoad(server.getLoad() + loadToAllocate);
                remainingLoad -= loadToAllocate;
            }
            if (remainingLoad <= 0) {
                return true;
            }
        }
        return false;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double loadToRelease = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double loadToReduction = Math.min(server.getLoad(), loadToRelease);
            server.setLoad(server.getLoad() - loadToReduction);
            loadToRelease -= loadToReduction;
            if (loadToRelease <= 0) {
                break;
            }
        }
    }

    public void optimize(DataCenter dataCenter, OptimizationStrategy strategy) {
        if (strategy != null) {
            strategy.optimize(dataCenter);
        }
    }


}
