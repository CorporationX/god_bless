package faang.school.godbless.task_13.optimization;

import faang.school.godbless.task_13.DataCenter;
import faang.school.godbless.task_13.Server;

import java.util.List;

public class LoadBalancingOptimization implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        if (dataCenter.getServers() == null || dataCenter.getServers().isEmpty()) {
            return;
        }

        double totalLoad = 0;
        double totalMaxLoad = 0;
        for (Server server : servers) {
            totalLoad += server.getLoad();
            totalMaxLoad += server.getMaxLoad();
        }

        double percentageLoad = totalLoad / totalMaxLoad;
        for (Server server : servers) {
            server.setLoad(server.getMaxLoad() * percentageLoad);
        }
    }
}
