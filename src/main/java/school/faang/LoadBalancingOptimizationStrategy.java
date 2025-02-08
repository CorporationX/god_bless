package school.faang;

import java.util.Comparator;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    private static final double EPSILON = 1e-9;

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double meanLoad = 0;
        for (Server server : servers) {
            meanLoad += server.getLoad();
        }
        double totalLoad = meanLoad;
        double distributedLoad = 0;
        meanLoad /= servers.size();

        for (Server server : servers) {
            double canDistribute = Math.min(meanLoad, server.getMaxLoad() - server.getLoad());
            distributedLoad += canDistribute;
            server.setLoad(canDistribute);
        }
        if (totalLoad - distributedLoad > EPSILON) {
            servers.sort(Comparator.comparingDouble(Server::getMaxLoad));
            for (Server server : servers) {
                double canDistribute = Math.min(totalLoad - distributedLoad,
                        server.getMaxLoad() - server.getLoad());
                distributedLoad += canDistribute;
                server.setLoad(canDistribute);
                if (totalLoad - distributedLoad < EPSILON) {
                    break;
                }
            }
        }
    }
}
