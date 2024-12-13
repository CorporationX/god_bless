package school.faang.task_45023;

import lombok.ToString;

@ToString
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    public void optimize(DataCenter dataCenter) {
        double totalLoad = dataCenter.getServers().stream()
                .map(Server::getLoad)
                .reduce(0.0, Double::sum);

        double totalMaxLoad = dataCenter.getServers().stream()
                .map(Server::getMaxLoad)
                .reduce(0.0, Double::sum);

        double kLoad = totalLoad / totalMaxLoad;

        if (kLoad < 1) {
            for (var server : dataCenter.getServers()) {
                server.setLoad(server.getMaxLoad() * kLoad);
            }
        }
    }
}
