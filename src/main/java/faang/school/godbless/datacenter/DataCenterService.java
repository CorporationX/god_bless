package faang.school.godbless.datacenter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService {

    private DataCenter dataCenter;

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void deleteServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        double total = 0;
        for (var server : dataCenter.getServers()) {
            total += server.getEnergyConsumption();
        }
        return total;
    }

    public void allocateResources(ResourceRequest request) {
        for (var server : dataCenter.getServers()) {
            if (isAvailableForAllocate(server, request.getLoad())) {
                server.setLoad(server.getLoad() + request.getLoad());
                break;
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        for (var server : dataCenter.getServers()) {
            if (isAvailableForRelease(server, request.getLoad())) {
                server.setLoad(server.getLoad() - request.getLoad());
                break;
            }
        }
    }

    public void optimizeStorage(OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }

    private boolean isAvailableForAllocate(Server server, double load) {
        return server.getMaxLoad() - server.getLoad() >= load;
    }

    private boolean isAvailableForRelease(Server server, double load) {
        return server.getLoad() >= load;
    }
}
