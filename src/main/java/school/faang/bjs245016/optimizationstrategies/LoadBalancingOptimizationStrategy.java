package school.faang.bjs245016.optimizationstrategies;

import school.faang.bjs245016.DataCenter;
import school.faang.bjs245016.OptimizationStrategy;
import school.faang.bjs245016.Server;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter datacenter) {
        System.out.println("Energy efficient optimization flow");

        List<Server> servers = datacenter.getServersList();
        double totalLoad = 0;

        for (Server server : servers) {
            totalLoad += server.getLoad();
        }

        double averageLoad = totalLoad / servers.size();

        for (Server server : servers) {
            server.setLoad(averageLoad);
        }
    }
}

