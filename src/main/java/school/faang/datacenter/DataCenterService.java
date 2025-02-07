package school.faang.datacenter;

public class DataCenterService {

    private final OptimizationStrategy optimizationStrategy;

    public DataCenterService(OptimizationStrategy optimizationStrategy) {
        this.optimizationStrategy = optimizationStrategy;
    }

    private void optimize(DataCenter dataCenter) {
        optimizationStrategy.optimize(dataCenter);
    }

    private void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    private void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().remove(server);
    }

    private double getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergy = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergy += server.getEnergyConsumption();
        }

        return totalEnergy;
    }

    private boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double allocatedLoad = request.getLoad();

        while (allocatedLoad > 0) {
            for (Server server : dataCenter.getServers()) {
                double permissibleLoad = server.getMaxLoad() - server.getLoad();

                if (permissibleLoad > allocatedLoad) {
                    server.setLoad(server.getLoad() + allocatedLoad);
                    allocatedLoad = 0;
                    break;
                } else if (permissibleLoad < allocatedLoad) {
                    double unitLoad = allocatedLoad - permissibleLoad;
                    allocatedLoad -= unitLoad;
                    server.setLoad(server.getLoad() + unitLoad);
                }
            }
        }

        return allocatedLoad < 0;
    }

    private void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double allocatedLoad = request.getLoad();

        while (allocatedLoad > 0) {
            for (Server server : dataCenter.getServers()) {
                if (server.getLoad() < allocatedLoad) {
                    server.setLoad(0);
                    allocatedLoad -= server.getLoad();
                } else if (server.getLoad() >= allocatedLoad) {
                    server.setLoad(server.getLoad() - allocatedLoad);
                    allocatedLoad = 0;
                }
            }
        }
    }

}
