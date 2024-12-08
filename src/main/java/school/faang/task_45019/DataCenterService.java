package school.faang.task_45019;

import lombok.Setter;

public class DataCenterService {
    private final DataCenter dataCenter;
    @Setter
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService() {
        this.dataCenter = new DataCenter();
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        if (dataCenter.getServers().remove(server)) {
            System.out.printf("%s has been removed successfully.%n", server);
        }

    }

    public double getTotalEnergyConsumption() {
        double totalEnergy = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergy += server.getEnergyConsumption();
        }
        return totalEnergy;
    }

    public double getTotalLoad() {
        double totalLoad = 0;
        for (Server server : dataCenter.getServers()) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    public double getTotalMaxLoad() {
        double totalMaxLoad = 0;
        for (Server server : dataCenter.getServers()) {
            totalMaxLoad += server.getMaxLoad();
        }
        return totalMaxLoad;
    }

    public int getServerCount() {
        return dataCenter.getServers().size();
    }

    public void allocateResources(ResourceRequest request) {
        double remainingLoad = request.load();
        for (Server server : dataCenter.getServers()) {
            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (availableLoad > 0) {
                double loadToAllocate = Double.min(remainingLoad, availableLoad);
                server.setLoad(server.getLoad() + loadToAllocate);
                remainingLoad -= loadToAllocate;
            }
            if (remainingLoad <= 0) {
                System.out.printf(
                        "Resources allocated successfully. Requested load: %s, allocated load: %s%n",
                        request.load(), (request.load() - remainingLoad)
                );
                return;
            }
        }

        System.out.printf(
                "Insufficient resources for allocation. Requested load: %s, allocated load: %s%n",
                request.load(), (request.load() - remainingLoad)
        );
    }

    public void releaseResources(ResourceRequest request) {
        double loadToRelease = request.load();
        for (Server server : dataCenter.getServers()) {
            double loadReduction = Double.min(loadToRelease, server.getLoad());
            server.setLoad(server.getLoad() - loadReduction);
            loadToRelease -= loadReduction;
            if (loadToRelease <= 0) {
                break;
            }
        }
    }

    public void optimize() {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        }
    }


    public void printAllServers() {
        for (Server server : dataCenter.getServers()) {
            System.out.println(server);
        }
    }

}
