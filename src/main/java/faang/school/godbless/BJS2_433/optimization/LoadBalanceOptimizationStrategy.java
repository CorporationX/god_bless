package faang.school.godbless.BJS2_433.optimization;

import faang.school.godbless.BJS2_433.DataCenter;
import faang.school.godbless.BJS2_433.Server;

import java.util.List;
import java.util.NoSuchElementException;

public class LoadBalanceOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter.getServerList().isEmpty()) throw new NoSuchElementException();

        List<Server> servers = dataCenter.getServerList();

        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double totalMaxLoads = servers.stream().mapToDouble(Server::getMaxLoad).sum();

        double currentCoefficient = totalLoad / totalMaxLoads;

        for (Server server : dataCenter.getServerList()) {
            server.setLoad(currentCoefficient * server.getMaxLoad());
        }
    }
}