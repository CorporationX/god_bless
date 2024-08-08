package faang.school.godbless.javahashmap.datacenter;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy{
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double averageLoad = totalLoad / servers.size();

        for (Server server : servers) {
            server.setLoad(averageLoad);
        }
    }
}
