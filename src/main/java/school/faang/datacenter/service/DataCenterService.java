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
        return dataCenter.addServer(server);
    }

    public boolean removeServer(DataCenter dataCenter, Server server) {
        return dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getTotalEnergyConsumption();
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        return dataCenter.allocateResources(request);
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        dataCenter.releaseResources(request);
    }

    public void optimize(DataCenter dataCenter, OptimizationStrategy strategy) {
        if (strategy != null) {
            strategy.optimize(dataCenter);
        }
    }
}