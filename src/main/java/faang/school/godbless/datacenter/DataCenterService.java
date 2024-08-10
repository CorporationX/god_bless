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

    public boolean allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.handleLoad(request.getLoad())) {
                return true;
            }
        }
        return false;
    }

    public boolean releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.releaseLoad(request.getLoad())) {
                return true;
            }
        }
        return false;
    }

    public void optimizeLoad() {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        }
    }
}