package school.faang.module1.bjs2_79747;

public class DataCenterService {

    public void addServer(DataCenter dataCenter, Server server) {
        if (dataCenter != null && server != null) {
            dataCenter.getServers().add(server);
        }
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        if (dataCenter != null && server != null) {
            dataCenter.getServers().remove(server);
        }
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {

        if (dataCenter == null || dataCenter.getServers() == null) {
            return 0.0;
        }
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        if (dataCenter == null || request == null || dataCenter.getServers() == null || dataCenter.getServers().isEmpty()) {
            return false;
        }
        double remainingLoad = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (availableLoad > 0) {
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
        if (dataCenter == null || request == null || dataCenter.getServers() == null || dataCenter.getServers().isEmpty()) {
            return;
        }
        double loadToRelease = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double loadReduction = Math.min(server.getLoad(), loadToRelease);
            server.setLoad(server.getLoad() - loadReduction);
            loadToRelease -= loadReduction;
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