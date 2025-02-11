package school.faang.sprint.first.datacenter.service.impl;

import lombok.NonNull;
import school.faang.sprint.first.datacenter.model.DataCenter;
import school.faang.sprint.first.datacenter.model.Server;
import school.faang.sprint.first.datacenter.service.OptimizationStrategy;

import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(@NonNull DataCenter dataCenter) {
        List<Server> dataCenterServers = dataCenter.getServers();
        double totalServersLoad = dataCenterServers.stream()
                .mapToDouble(Server::getLoad)
                .sum();

        dataCenterServers.forEach(server -> server.setLoad(0));

        for (Server server : dataCenterServers) {
            double serverMaxLoad = server.getMaxLoad();

            if (totalServersLoad == 0.0) {
                return;
            }

            if (totalServersLoad > serverMaxLoad) {
                totalServersLoad -= serverMaxLoad;
                server.setLoad(serverMaxLoad);
            } else {
                server.setLoad(totalServersLoad);
                totalServersLoad = 0.0;
            }

            server.updateEnergyConsumption(server.getLoad(), serverMaxLoad);
        }
    }
}
