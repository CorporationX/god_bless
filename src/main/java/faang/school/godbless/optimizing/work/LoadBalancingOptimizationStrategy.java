package faang.school.godbless.optimizing.work;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy{
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        if (servers.isEmpty()) {
            return;
        }


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
