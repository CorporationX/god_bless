package school.faang.sprint_1.task_45040;

public class DataCenterService {
    private final DataCenter dataCenter;
    private final OptimizationStrategy optimizationStrategy;

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
        return dataCenter.getTotalEnergyConsumption();
    }

    public void allocateResources(ResourceRequest request) {
        double remainingLoad = request.getLoad();

        for (Server server : dataCenter.getServers()) {
            if (server.getMaxLoad() - server.getLoad() >= remainingLoad) {
                server.addLoad(remainingLoad);
                return;
            } else {
                double availableLoad = server.getMaxLoad() - server.getLoad();
                server.addLoad(availableLoad);
                remainingLoad -= availableLoad;
            }
        }

        if (remainingLoad > 0) {
            throw new IllegalArgumentException("Недостаточно возможностей для распределения всех ресурсов");
        }
    }

    public void releaseResources(ResourceRequest request) {
        double remainingLoad = request.getLoad();

        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() >= remainingLoad) {
                server.removeLoad(remainingLoad);
                return;
            } else {
                remainingLoad -= server.getLoad();
                server.removeLoad(server.getLoad());
            }
        }
    }

    public void optimize() {
        optimizationStrategy.optimize(dataCenter);
    }

    public void scheduleOptimization() {
    }
}
