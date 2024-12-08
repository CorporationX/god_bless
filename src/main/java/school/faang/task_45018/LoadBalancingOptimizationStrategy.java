package school.faang.task_45018;

import java.util.List;
import java.util.OptionalDouble;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getDataCenters();
        OptionalDouble averageLoad = servers.stream()
                .mapToDouble(Server::getLoad)
                .average();

        if (averageLoad.isPresent()) {
            for (Server server : servers) {
                server.setLoad(averageLoad.getAsDouble());
            }
        }
    }
}