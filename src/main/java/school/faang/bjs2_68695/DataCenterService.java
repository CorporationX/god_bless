package school.faang.bjs2_68695;

public class DataCenterService {

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.servers().add(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.servers().remove(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergyConsumption = 0.0;
        for (Server server : dataCenter.servers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double remainingAllocateLoad = request.load();
        for (Server server : dataCenter.servers()) {
            double availableServerLoad = server.getMaxLoad() - server.getLoad();
            double allocatedLoad = Math.min(remainingAllocateLoad, availableServerLoad);
            server.setLoad(server.getLoad() + allocatedLoad);
            remainingAllocateLoad -= allocatedLoad;
            if (remainingAllocateLoad <= 0.0) {
                return true;
            }
        }
        return false;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double remainingReleaseLoad = request.load();
        for (Server server : dataCenter.servers()) {
            double releasedLoad = Math.min(remainingReleaseLoad, server.getLoad());
            server.setLoad(server.getLoad() - releasedLoad);
            remainingReleaseLoad -= releasedLoad;
            if (remainingReleaseLoad <= 0.0) {
                break;
            }
        }
    }

    public void optimize(DataCenter dataCenter, OptimizationStrategy strategy) {
        if (strategy != null) {
            strategy.optimize(dataCenter); // Применяем стратегию
        }
    }
}
