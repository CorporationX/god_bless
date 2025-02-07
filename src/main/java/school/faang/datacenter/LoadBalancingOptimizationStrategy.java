package school.faang.datacenter;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
        double unitLoad = totalLoad / servers.size();

        loadDistribution(totalLoad, unitLoad, servers);
    }

    private static void loadDistribution(double totalLoad, double unitLoad, List<Server> servers) {
        List<Server> unloadedServers = new ArrayList<>();
        for (Server server : servers) {
            if (unitLoad < server.getMaxLoad()) {
                server.setLoad(unitLoad);

                totalLoad -= unitLoad;
            } else {
                unloadedServers.add(server);
            }
        }

        if (totalLoad > 0) {
            double newUnitLoad = totalLoad / unloadedServers.size();
            loadDistribution(totalLoad, newUnitLoad, unloadedServers);
        }
    }
}
