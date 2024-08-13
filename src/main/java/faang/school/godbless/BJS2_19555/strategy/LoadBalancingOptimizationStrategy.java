package faang.school.godbless.BJS2_19555.strategy;

import faang.school.godbless.BJS2_19555.DataCenter;
import faang.school.godbless.BJS2_19555.Server;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double avgLoad = countAvgLoad(servers);
        for (Server server : servers) {
            if (server.getLoad() > avgLoad) {
                double overload = server.getLoad() - avgLoad;
                servers.stream()
                        .filter(unloadedServer -> unloadedServer.getLoad() + overload <= avgLoad
                                && unloadedServer.getAvailableLoad() >= overload)
                        .findFirst()
                        .ifPresent(unloadedServer -> {
                            server.changeEnergyConsumption(server.getLoad(), server.decreaseLoad(overload));
                            unloadedServer.changeEnergyConsumption(unloadedServer.getLoad(),
                                    unloadedServer.increaseLoad(overload));
                        });
            }
        }
    }

    private double countAvgLoad(List<Server> servers) {
        double totalLoad = servers.stream()
                .mapToDouble(Server::getMaxLoad)
                .sum();
        return totalLoad / servers.size();
    }
}
