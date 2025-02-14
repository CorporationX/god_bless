package school.faang.optimizing;

import lombok.Data;

@Data

public class DataCenterService {
    private OptimizationStrategy optimizationStrategy;

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().remove(server);
    }

    public static double getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergy = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergy += server.getEnergyConsumption();
        }
        return totalEnergy;
    }

    public static boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double remainingLoad = request.getLoad();

        for (Server server : dataCenter.getServers()) {
            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (availableLoad > 0) {
                double loadToAllocate = Math.min(availableLoad, remainingLoad);
                server.setLoad(server.getLoad() + loadToAllocate);
                server.setLoad(server.getLoad() * 0.2);
                remainingLoad -= loadToAllocate;
            }
            if (remainingLoad <= 0) {
                return true;
            }
        }
        return false;
    }

    public static void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double loadToRelease = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double loadReduction = Math.min(server.getLoad(), loadToRelease);
            server.setLoad(server.getLoad() - loadReduction);
            server.setLoad(server.getLoad() * 0.5);
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
