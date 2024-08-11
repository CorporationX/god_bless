package faang.school.godbless.task.hashmap.database.optimization;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    private static final double ACCEPTABLE_AVERAGE_LOAD_HIGH = 60;
    private static final double ACCEPTABLE_AVERAGE_LOAD_LOW = 30;

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = getTotalLoad(servers);
        double middleLoad = totalLoad / servers.size();

        if (middleLoad < ACCEPTABLE_AVERAGE_LOAD_HIGH &&
                middleLoad > ACCEPTABLE_AVERAGE_LOAD_LOW) {
            optimizeInAverageLoad(totalLoad, servers);
        } else if (middleLoad > ACCEPTABLE_AVERAGE_LOAD_HIGH) {
            servers.add(new Server());
            optimizeInAverageLoad(totalLoad, dataCenter.getServers());
        } else if (middleLoad < ACCEPTABLE_AVERAGE_LOAD_LOW) {
            servers.remove(servers.size() - 1);
            optimizeInAverageLoad(totalLoad, dataCenter.getServers());
        }
    }

    public double getTotalLoad(List<Server> servers) {
        double totalLoad = 0;
        for (Server server : servers) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    public void optimizeInAverageLoad(double totalLoad, List<Server> servers) {
        double middleLoad = totalLoad / servers.size();
        servers.forEach(server -> {
            double load = server.getLoad();
            if (load > middleLoad) {
                server.releaseLoad(load - middleLoad);
            } else if (load < middleLoad) {
                server.allocateLoad(middleLoad - load);
            }
        });
    }
}
