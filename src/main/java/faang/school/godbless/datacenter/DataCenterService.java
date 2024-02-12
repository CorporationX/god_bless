package faang.school.godbless.datacenter;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;

    public void addNewServer(double load, double maxLoad, double energyConsumption) {
        Server server = new Server(load, maxLoad, energyConsumption);
        dataCenter.getServerList().add(server);
    }

    public void removeServerFromDataCenter(Server server) {
        ResourceRequest request = new ResourceRequest(server.getLoad());
        allocateResources(request);
        dataCenter.getServerList().remove(server);
    }

    public double getTotalEnergyConsumption() {
        double total = 0;
        for (var server : dataCenter.getServerList()) {
            total += server.getEnergyConsumption();
        }
        return total;
    }

    public void allocateResources(ResourceRequest request) {
        double toAllocate = request.getLoad();
        for (var server : dataCenter.getServerList()) {
            double possiblyLoad = server.getLoad() + toAllocate;
            if (server.getMaxLoad() > possiblyLoad) {
                server.setLoad(possiblyLoad);
                break;
            } else {
                double temp = server.getMaxLoad() - server.getLoad();
                server.setLoad(server.getMaxLoad());
                toAllocate -= temp;
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        for (var server : dataCenter.getServerList()) {
            if (server.getLoad() >= request.getLoad()) {
                server.setLoad(server.getLoad() - request.getLoad());
                break;
            }
        }
    }

    public void runOptimization(OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }

}
