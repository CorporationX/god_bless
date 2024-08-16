package faang.school.godbless.BJS2_19303;

import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

@NoArgsConstructor
public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        if (servers.isEmpty()) {
            throw new IllegalArgumentException("No servers found");
        }

        servers.sort(Comparator.comparingDouble(Server::getEnergyConsumption));

        double remains = servers.stream().mapToDouble(Server::getLoad).sum();

        for (Server server : servers) {
            double maxAddableLoad = server.getMaxLoad();
            double additionalLoad = Math.min(remains, maxAddableLoad);
            server.setLoad(additionalLoad);
            remains -= additionalLoad;
            if (remains <= 0) break;
        }
    }
}
