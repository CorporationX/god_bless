package school.faang.datacenter;

public class DataCenterService {

    private final OptimizationStrategy optimizationStrategy;

    public DataCenterService(OptimizationStrategy optimizationStrategy) {
        this.optimizationStrategy = optimizationStrategy;
    }

    public void optimize(DataCenter dataCenter) {
        optimizationStrategy.optimize(dataCenter);
    }

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.servers().add(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.servers().remove(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergy = 0;
        for (Server server : dataCenter.servers()) {
            totalEnergy += server.getEnergyConsumption();
        }

        return totalEnergy;
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double allocatedLoad = request.load();

        for (Server server : dataCenter.servers()) {
            double permissibleLoad = server.getMaxLoad() - server.getLoad();

            if (permissibleLoad > 0) {
                if (permissibleLoad > allocatedLoad) {
                    server.setLoad(server.getLoad() + allocatedLoad);
                    allocatedLoad = 0;
                    break;
                } else {
                    allocatedLoad -= permissibleLoad;
                    server.setLoad(server.getLoad() + permissibleLoad);
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

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double allocatedLoad = request.load();

        while (allocatedLoad > 0) {
            for (Server server : dataCenter.servers()) {
                if (server.getLoad() < allocatedLoad) {
                    allocatedLoad -= server.getLoad();
                    server.setLoad(0);
                } else {
                    server.setLoad(server.getLoad() - allocatedLoad);
                    allocatedLoad = 0;
                }
            }
        }
    }

}
