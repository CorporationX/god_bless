package school.faang.optimization;


public class DataCenterService {

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergy = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergy += server.getEnergyConsumption();
        }
        return totalEnergy;
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double remainingLoad = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() + remainingLoad <= server.getMaxLoad()) {
                server.setLoad(server.getLoad() + remainingLoad);
                return true;
            } else {
                remainingLoad -= (server.getMaxLoad() - server.getLoad());
                server.setLoad(server.getMaxLoad());
            }
        }
        return false;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double loadToRelease = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() >= loadToRelease) {
                server.setLoad(server.getLoad() - loadToRelease);
                break;
            } else {
                loadToRelease -= server.getLoad();
                server.setLoad(0);
            }
        }
    }

    public void optimize(DataCenter dataCenter, OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }
}
