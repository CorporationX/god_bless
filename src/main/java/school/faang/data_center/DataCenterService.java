package school.faang.data_center;

import school.faang.library.Main;

public class DataCenterService {

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    public void deleteServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().removeIf(serverFromDataCenter -> serverFromDataCenter.equals(server));
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalConsumption += server.getEnergyConsumption();
        }
        return totalConsumption;
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest resourceRequest) {
        double requstedLoad = resourceRequest.getLoad();
        for (Server server : dataCenter.getServers()) {
            double remainingLoad = server.getMaxLoad() - server.getLoad();
            if (requstedLoad > remainingLoad) {
                server.setLoad(server.getLoad() + remainingLoad);
                requstedLoad -= remainingLoad;
            } else {
                server.setLoad(requstedLoad);
                return true;
            }
        }
        return false;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest resourceRequest) {
        double requestedLoad = resourceRequest.getLoad();
        for (Server server : dataCenter.getServers()) {
            double calcRelease = Math.min(server.getLoad(), requestedLoad);
            server.setLoad(server.getLoad() - calcRelease);
            requestedLoad -= calcRelease;
            if (requestedLoad <= 0) {
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
