package optimize_data_center_work;

import lombok.AllArgsConstructor;

import java.util.Comparator;
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

    public void optimizeLoad() {
        optimizationStrategy.optimize(dataCenter);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;

        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }

        return totalEnergyConsumption;
    }
    public void allocateResources(ResourceRequest request) {
        double remainingLoad = request.getLoad();
        List<Server> servers = dataCenter.getServers();

        // Sort servers based on their current load (ascending order)
        servers.sort(Comparator.comparingDouble(Server::getLoad));

        for (Server server : servers) {
            double availableCapacity = server.getMaxLoad() - server.getLoad();
            if (remainingLoad <= availableCapacity) {
                // Allocate remainingLoad to this server
                server.setLoad(server.getLoad() + remainingLoad);
                break;
            } else {
                // Allocate availableCapacity to this server
                server.setLoad(server.getMaxLoad());
                remainingLoad -= availableCapacity;
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        double releasedLoad = request.getLoad();
        List<Server> servers = dataCenter.getServers();

        // Sort servers based on their current load (descending order)
        servers.sort(Comparator.comparingDouble(Server::getLoad).reversed());

        for (Server server : servers) {
            double releasedCapacity = server.getLoad();
            if (releasedLoad <= releasedCapacity) {
                // Release releasedLoad from this server
                server.setLoad(server.getLoad() - releasedLoad);
                break;
            } else {
                // Release releasedCapacity from this server
                server.setLoad(0.0);
                releasedLoad -= releasedCapacity;
            }
        }
    }
}
