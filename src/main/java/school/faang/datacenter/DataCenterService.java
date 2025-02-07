package school.faang.datacenter;

public class DataCenterService {

    private final OptimizationStrategy optimizationStrategy;

    public DataCenterService(OptimizationStrategy optimizationStrategy) {
        this.optimizationStrategy = optimizationStrategy;
    }

    public void optimize(DataCenter dataCenter) {
        optimizationStrategy.optimize(dataCenter);
    }

    private void addServer(DataCenter dataCenter, Server server) {
        dataCenter.servers().add(server);
    }

    private void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.servers().remove(server);
    }

    private double getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergy = 0;
        for (Server server : dataCenter.servers()) {
            totalEnergy += server.getEnergyConsumption();
        }

        return totalEnergy;
    }

    private boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double allocatedLoad = request.load();

        for (Server server : dataCenter.servers()) {
            double permissibleLoad = server.getMaxLoad() - server.getLoad();

            if (permissibleLoad > 0) {
                if (permissibleLoad > allocatedLoad) {
                    server.setLoad(server.getLoad() + allocatedLoad);
                    allocatedLoad = 0;
                    break;
                } else {
                    double unitLoad = allocatedLoad - permissibleLoad;
                    allocatedLoad -= unitLoad;
                    server.setLoad(server.getLoad() + unitLoad);
                }
            }
        }

        if (allocatedLoad > 0) {
            System.out.println("All servers are loaded");
            return false;
        } else {
            return true;
        }
    }

    private void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double allocatedLoad = request.load();

        while (allocatedLoad > 0) {
            for (Server server : dataCenter.servers()) {
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
