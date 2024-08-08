package faang.school.godbless.BJS2_19303;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        if (servers.isEmpty()) {
            throw new IllegalArgumentException("No servers found");
        }

        double totalMaxLoad = servers.stream().mapToDouble(Server::getMaxLoad).sum();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double remains = totalLoad;

        for (Server server : servers) {
            double perfectLoad = (server.getMaxLoad() / totalMaxLoad) * totalLoad;
            server.setLoad(perfectLoad);
            remains -= perfectLoad;
        }
        if (remains > 0) {
            for (Server server : servers) {
                double leastCapacity = server.getMaxLoad() - server.getLoad();
                double additionalLoad = Math.min(remains, leastCapacity);
                server.setLoad(server.getLoad() + additionalLoad);
                remains -= additionalLoad;
                if (remains <= 0) {
                    break;
                }
            }
        }
    }

}
