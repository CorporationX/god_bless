package school.faang.task_45020;

public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy strategy;

    public DataCenterService(DataCenter dataCenter, OptimizationStrategy strategy) {
        this.dataCenter = dataCenter;
        this.strategy = strategy;
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public void optimize(DataCenter dataCenter) {
        strategy.optimize(dataCenter);
    }

    public void allocateResources(ResourceRequest request) {
        double remainingLoad = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (availableLoad > 0) {
                double toAllocate = Math.min(remainingLoad, availableLoad);
                server.setLoad(server.getLoad() + toAllocate);
                remainingLoad -= toAllocate;

                if (remainingLoad <= 0) {
                    break;
                }
            }
        }

        if (remainingLoad > 0) {
            System.out.println("Unable to allocate " + remainingLoad + " units.");
        }
    }

    public void releaseResources(ResourceRequest request) {
        double remainingLoad = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (remainingLoad >= server.getLoad()) {
                remainingLoad = remainingLoad - server.getLoad();
                server.setLoad(0.0);
            } else {
                server.setLoad(server.getLoad() - remainingLoad);
                remainingLoad = 0;
            }
            if (remainingLoad == 0) {
                break;
            }
        }
    }

    public double getTotalEnergyConsumption() {
        double total = 0.0;
        for (Server server : dataCenter.getServers()) {
            total += server.getEnergyConsumption();
        }

        return total;
    }

    public void setStrategy(OptimizationStrategy strategy) {
        this.strategy = strategy;
    }
}
