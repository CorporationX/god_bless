package faang.school.godbless.datacenter.service;

import faang.school.godbless.datacenter.model.DataCenter;
import faang.school.godbless.datacenter.model.ResourceRequest;
import faang.school.godbless.datacenter.model.Server;
import faang.school.godbless.datacenter.strategy.OptimizationStrategy;

public record DataCenterService(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {

    public void addServer(Server server) {
        throw new UnsupportedOperationException();
    }

    public void deleteServer(Server server) {
        throw new UnsupportedOperationException();
    }

    public double getTotalEnergyConsumption() {
        throw new UnsupportedOperationException();
    }

    public void allocateResources(ResourceRequest resourceRequest) {
        throw new UnsupportedOperationException();
    }

    public void releaseResources(ResourceRequest resourceRequest) {
        throw new UnsupportedOperationException();
    }
}
