package faang.school.godbless.optimization_data_center.optimization;

import faang.school.godbless.optimization_data_center.DataCenter;
import faang.school.godbless.optimization_data_center.Server;

import java.util.Comparator;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimization(DataCenter dataCenter) {

        List<Server> servers = dataCenter.getServers();
        double currentTotalLoad = servers.stream()
                .reduce(0.0, (result, server) -> result + server.getLoad(), Double::sum);
        int countServers = servers.size();

        double minMaxLoadOnServer = servers.stream()
                .min(Comparator.comparingDouble(Server::getMaxLoad))
                .get()
                .getMaxLoad();

        if (minMaxLoadOnServer > currentTotalLoad / countServers) {
            final double loadPerEachServer = currentTotalLoad / countServers;
            servers.forEach(server -> server.setLoad(loadPerEachServer));
        } else {

            servers.forEach(server -> server.setLoad(minMaxLoadOnServer));

            currentTotalLoad -= countServers * minMaxLoadOnServer;

            for (Server server : servers) {
                double partOfAllocateResources = server.availableResourcesForAllocate(currentTotalLoad);
                currentTotalLoad -= partOfAllocateResources;
                if (currentTotalLoad == 0) {
                    break;
                }
            }

        }

    }

}
