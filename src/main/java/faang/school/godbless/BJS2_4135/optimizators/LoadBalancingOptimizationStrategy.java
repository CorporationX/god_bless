package faang.school.godbless.BJS2_4135.optimizators;

import faang.school.godbless.BJS2_4135.models.DataCenter;
import faang.school.godbless.BJS2_4135.models.Server;

import java.util.Comparator;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double targetLoadPerServer = totalLoad / servers.size();

        servers.sort(Comparator.comparingDouble(Server::getLoad));

        for (int i = 0; i < servers.size(); i++) {
            Server server = servers.get(i);
            for (int j = servers.size() - 1; j > i; j--) {
                Server highLoadServer = servers.get(j);
                double currentLoad = server.getLoad();
                double highCurrentLoad = highLoadServer.getLoad();
                double maxCapacity = server.getMaxLoad();

                if (currentLoad < targetLoadPerServer && highCurrentLoad > targetLoadPerServer) {
                    double transferLoad = Math.min(highCurrentLoad - targetLoadPerServer, maxCapacity - currentLoad);
                    server.allocate(transferLoad);
                    highLoadServer.release(transferLoad);
                }
            }
        }
    }
}
