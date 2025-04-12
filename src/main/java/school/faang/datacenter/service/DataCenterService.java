package school.faang.datacenter.service;

import lombok.RequiredArgsConstructor;
import school.faang.datacenter.strategy.OptimizationStrategy;
import school.faang.datacenter.model.DataCenter;
import school.faang.datacenter.model.ResourceRequest;
import school.faang.datacenter.model.Server;

@RequiredArgsConstructor
public class DataCenterService {
    private final OptimizationStrategy optimizationStrategy;

    public Server addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
        return server;
    }

    public boolean removeServer(DataCenter dataCenter, Server server) {
        return dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getServers().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double remainingLoad = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double remainingOnServer = server.getMaxLoad() - server.getLoad();
            if (remainingOnServer >= remainingLoad) {
                server.setLoad(remainingOnServer - remainingLoad + server.getLoad());
                remainingLoad = 0;
                break;
            } else {
                remainingLoad -= server.getMaxLoad() - server.getLoad();
                server.setLoad(server.getMaxLoad());
            }
        }
        return remainingLoad == 0;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double loadToRemain = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() > loadToRemain) {
                server.setLoad(server.getLoad() - loadToRemain);
                break;
            } else {
                loadToRemain -= server.getLoad();
                server.setLoad(0);
            }
        }
    }

    public void optimize(DataCenter dataCenter, OptimizationStrategy strategy) {
        if (strategy != null) {
            strategy.optimize(dataCenter);
        }
    }
}