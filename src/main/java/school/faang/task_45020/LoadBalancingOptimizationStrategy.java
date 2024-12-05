package school.faang.task_45020;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        servers.sort((s1, s2) -> (int) (s1.getLoad() - s2.getLoad()));
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double averageLoad = totalLoad / servers.size();
        double size = servers.size();
        double counter = 0;

        for (Server server : dataCenter.getServers()) {
            counter++;
            if (server.getLoad() < averageLoad) {
                double diff = averageLoad - server.getLoad();
                if (server.getMaxLoad() - server.getLoad() >= diff) {
                    server.setLoad(server.getLoad() + diff);
                } else {
                    diff -= (server.getMaxLoad() - server.getLoad());
                    averageLoad += diff / (size - counter);
                    server.setLoad(server.getMaxLoad());
                }
            } else {
                double remaining = server.getLoad() - averageLoad;
                server.setLoad(server.getLoad() - remaining);
            }
        }

    }
}
