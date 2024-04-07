package faang.school.godbless.sprint_1.optimization_data_center.optimization;

import faang.school.godbless.sprint_1.optimization_data_center.DataCenter;
import faang.school.godbless.sprint_1.optimization_data_center.Server;

import java.util.Comparator;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {

        List<Server> servers = dataCenter.getServers();
        double currentTotalLoad = dataCenter.getTotalByExpression((result, server) -> result + server.getLoad());
        int countServers = servers.size();
        double minMaxLoadOnServer = servers.stream()
                .min(Comparator.comparingDouble(Server::getMaxLoad))
                .get()
                .getMaxLoad();

        if (minMaxLoadOnServer > currentTotalLoad / countServers) {
            double loadPerEachServer = currentTotalLoad / countServers;
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
