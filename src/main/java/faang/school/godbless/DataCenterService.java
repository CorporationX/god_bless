package faang.school.godbless;

public class DataCenterService {
    DataCentre dataCenter = new DataCentre();
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService() {
        this.optimizationStrategy = optimizationStrategy;
    }

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption(){
        return dataCenter.getTotalEnergyConsumption();
    }

    public void allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.canHandleLoad(request.getLoad())) {
                server.addLoad(request.getLoad());
                return;
            }
        }
        throw new IllegalStateException("No server can handle the requested load");
    }

    public void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() >= request.getLoad()) {
                server.removeLoad(request.getLoad());
                return;
            }
        }
        throw new IllegalStateException("No server has enough load to release");
    }

    public void optimize() {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        }
    }
}
