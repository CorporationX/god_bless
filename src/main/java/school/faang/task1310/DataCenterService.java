package school.faang.task1310;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService {

    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption() {
        double allEnergyConsumption = 0.0;
        for (Server server : dataCenter.getAllServers()) {
            allEnergyConsumption += server.getEnergyConsumption();
        }
        return allEnergyConsumption;
    }

    public boolean allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getAllServers()) {
            if (server.getLoad() + request.getLoad() < server.getMaxLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
                return true;
            }
        }
        return false;
    }

    public void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getAllServers()) {
            if (server.getLoad() + request.getLoad() > server.getMaxLoad()) {
                server.setLoad(server.getLoad() - request.getLoad());
            }
        }
    }

    public void printAllServer() {
        for (Server server : dataCenter.getAllServers()) {
            System.out.println(server);
        }
    }

    public void optimize() {
        optimizationStrategy.optimize(dataCenter);
    }
}
