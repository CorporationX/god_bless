package faang.school.godbless.datacenter;

import lombok.Setter;

public class DataCenterService {
    private DataCenter dataCenter;
    @Setter
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.canHandleLoad(request.getLoad())) {
                server.allocateLoad(request.getLoad());
                return;
            }
        }
        throw new RuntimeException("Not enough resources available to handle the request.");
    }

    public void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() >= request.getLoad()) {
                server.releaseLoad(request.getLoad());
                return;
            }
        }
        throw new RuntimeException("No server found with enough load to release.");
    }

    public void optimizeLoad() {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        }
    }
}