package school.faang.optimization;

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

        for (Server server : servers) {
            if (server.getLoad() > averageLoad) {
                double excessLoad = server.getLoad() - averageLoad;
                server.setLoad(averageLoad);

                for (Server otherServer : servers) {
                    if (otherServer.getLoad() < averageLoad) {
                        double availableCapacity = averageLoad - otherServer.getLoad();
                        if (excessLoad <= availableCapacity) {
                            otherServer.setLoad(otherServer.getLoad() + excessLoad);
                            break;
                        } else {
                            otherServer.setLoad(averageLoad);
                            excessLoad -= availableCapacity;
                        }
                    }
                }
            }
        }
    }
}
