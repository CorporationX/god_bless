package school.faang.bjs245028.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import school.faang.bjs245028.balancer.OptimizationStrategy;
import school.faang.bjs245028.model.DataCenter;
import school.faang.bjs245028.model.ResourceRequest;
import school.faang.bjs245028.model.Server;

@RequiredArgsConstructor
public class DataCenterService implements DataCenterProvider, OptimizationStrategy {

    private final DataCenter dataCenter;
    private final OptimizationStrategy strategy;

    @Override
    public void addServer(Server server) {
        validate(server);
        dataCenter.getServers().add(server);
    }

    private void validate(Server server) {
        if (server == null) {
            throw new IllegalArgumentException("Server must be not null");
        }
    }

    @Override
    public void removeServer(Server server) {
        validate(server);
        dataCenter.getServers().remove(server);
    }

    @Override
    public double getTotalEnergyConsumption() {
        return dataCenter.getServers()
                .stream()
                .mapToDouble(Server::energyConsumption)
                .sum();
    }

    @Override
    public void allocateResources(ResourceRequest request) {



    }

    @Override
    public void releaseResources(ResourceRequest request) {

    }

    @Override
    public void optimize(DataCenter dataCenter) {

    }
}
