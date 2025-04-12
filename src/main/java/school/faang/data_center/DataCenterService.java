package school.faang.data_center;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

    public void allocateResources(DataCenter dataCenter, ResourceRequest resourceRequest) {
        double requestedLoad = resourceRequest.getLoad();
        for (Server server : dataCenter.getServers()) {
            double remainingLoad = server.getMaxLoad() - server.getLoad();
            if (requestedLoad > remainingLoad) {
                server.setLoad(server.getLoad() + remainingLoad);
                requestedLoad -= remainingLoad;
            } else {
                server.setLoad(requestedLoad);
                log.info("{} resources were distributed between servers", resourceRequest.getLoad());
            }
        }
        if (requestedLoad > 0) {
            log.info("{} resources are exceeding total data center load capacity", resourceRequest.getLoad());
        }
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
        log.info("{} resources were released from data center", resourceRequest.getLoad());
    }

    public void optimize(DataCenter dataCenter, OptimizationStrategy strategy) {
        if (strategy != null) {
            strategy.optimize(dataCenter);
        }
    }
}
