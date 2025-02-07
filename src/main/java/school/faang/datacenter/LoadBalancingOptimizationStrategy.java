package school.faang.datacenter;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.servers();
        double totalLoad = dataCenter.servers().stream().mapToDouble(Server::getLoad).sum();
        double unitLoad = totalLoad / servers.size();

        servers.forEach(server -> server.setLoad(0));
        loadDistribution(totalLoad, unitLoad, servers);
    }

    private static void loadDistribution(double totalLoad, double unitLoad, List<Server> servers) {
        List<Server> unloadedServers = new ArrayList<>();

        for (Server server : servers) {
            double currentLoad = server.getLoad() + unitLoad;
            if (currentLoad <= server.getMaxLoad()) {
                server.setLoad(currentLoad);

                totalLoad -= unitLoad;

                unloadedServers.add(server);
            } else {
                server.setLoad(server.getMaxLoad());
                totalLoad -= server.getMaxLoad();
            }
            server.setEnergyConsumption(server.getLoad(), server.getMaxLoad());
        }

        if (totalLoad > 0) {
            double newUnitLoad = totalLoad / unloadedServers.size();
            loadDistribution(totalLoad, newUnitLoad, unloadedServers);
        }
    }
}
