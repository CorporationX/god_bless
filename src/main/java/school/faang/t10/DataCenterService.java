package school.faang.t10;

public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        this.dataCenter = dataCenter;
        this.optimizationStrategy = optimizationStrategy;
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
            if (server.getLoad() + request.getLoad() <= server.getMaxLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
                return true;
            }
        }
        return false; // капут
    }

    public boolean releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() >= request.getLoad()) {
                server.setLoad(server.getLoad() - request.getLoad());
                return true;
            }
        }
        return false; // капут
    }

    public void optimizeDataCenter() {
        optimizationStrategy.optimize(dataCenter);
    }

    public void scheduleOptimization() {
        optimizeDataCenter();
    }
}
