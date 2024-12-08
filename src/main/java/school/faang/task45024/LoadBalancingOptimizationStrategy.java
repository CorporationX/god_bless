package school.faang.task45024;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {

        List<Server> servers = dataCenter.getServers();

        double result = 0;

        for (var server : servers) {
            result += server.getLoad();
        }

        double average = result / servers.size();

        for (var server : servers) {
            server.setLoad(average);
        }
    }
}
