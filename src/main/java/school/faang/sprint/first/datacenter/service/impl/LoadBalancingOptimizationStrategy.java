package school.faang.sprint.first.datacenter.service.impl;


import lombok.NonNull;
import school.faang.sprint.first.datacenter.model.DataCenter;
import school.faang.sprint.first.datacenter.model.Server;
import school.faang.sprint.first.datacenter.service.OptimizationStrategy;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(@NonNull DataCenter dataCenter) {
        List<Server> dataCenterServers = dataCenter.getServers();

        double totalLoad = dataCenterServers.stream()
                .mapToDouble(Server::getLoad)
                .sum();
        double totalMaxLoad = dataCenterServers.stream()
                .mapToDouble(Server::getMaxLoad)
                .sum();

        dataCenterServers.forEach(server -> server.setLoad(0));

        double sumOfNewLoad = 0.0;
        for (Server server : dataCenterServers) {
            double newLoad = Math.floor((totalLoad * server.getMaxLoad()) / totalMaxLoad);
            System.out.println(newLoad);
            server.setLoad(newLoad);
            sumOfNewLoad += newLoad;
        }

        double remainLoad = totalLoad - sumOfNewLoad;
        if (remainLoad > 0) {
            Server server = dataCenterServers.get(0);
            server.setLoad(server.getLoad() + remainLoad);
        } else if (remainLoad < 0) {
            Server server = dataCenterServers.get(0);
            server.setLoad(server.getLoad() - remainLoad);
        }
    }
}
