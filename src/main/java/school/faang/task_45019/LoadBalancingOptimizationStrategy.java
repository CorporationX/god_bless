package school.faang.task_45019;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = 0;

        for (Server server : servers) {
            totalLoad += server.getLoad();
        }

        double averageLoad = totalLoad / servers.size();

        double remainingLoad = 0;
        for (Server server : servers) {
            double loadIncrease = Double.min(averageLoad, server.getMaxLoad());
            server.setLoad(loadIncrease);
            remainingLoad += averageLoad - loadIncrease;
        }

        if (remainingLoad > 0) {
            for (Server server : servers) {
                double availableLoad = server.getMaxLoad() - server.getLoad();
                if (availableLoad > 0) {
                    double loadToAllocate = Double.min(remainingLoad, availableLoad);
                    server.setLoad(server.getLoad() + loadToAllocate);
                    remainingLoad -= loadToAllocate;
                }
                if (remainingLoad <= 0) {
                    break;
                }
            }
        }
    }

}
