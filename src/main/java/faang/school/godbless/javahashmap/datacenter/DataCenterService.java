package faang.school.godbless.javahashmap.datacenter;

import lombok.AllArgsConstructor;

import java.util.List;

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
        return dataCenter.getTotalEnergyConsumption();
    }

    public boolean allocateResources(ResourceRequest request) {
        double additionalLoad = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (server.handleLoad(additionalLoad)) {
                return true;
            }
        }
        return false;
    }

    public boolean releaseResources(ResourceRequest request) {
        double loadToRelease = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (server.releaseLoad(loadToRelease)) {
                return true;
            }
        }
        return false;
    }

    public void optimizeLoad() {
        optimizationStrategy.optimize(dataCenter);
    }

    public void printServers() {
        List<Server> servers = dataCenter.getServers();
        System.out.println("\nQuantity of servers in the data center: " + servers.size());
        System.out.println("Total energy consumption is " + getTotalEnergyConsumption());
        System.out.println("Total load is " + servers.stream().mapToDouble(Server::getLoad).sum());
        for (Server server : servers) {
            System.out.println("    Server: " + server);
        }
    }
}
