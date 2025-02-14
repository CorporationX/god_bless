package school.faang;

import java.util.Comparator;
import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        servers.sort(Comparator.comparingDouble(Server::getEnergyConsumption));

        double remainingLoad = servers.stream().mapToDouble(Server::getLoad).sum();

        for (Server server : servers) {
            double loadForServer = Math.min(remainingLoad, server.getMaxLoad());
            server.setLoad(loadForServer);
            remainingLoad -= loadForServer;
            if (remainingLoad <= 0) {
                break;
            }
        }

        if (remainingLoad > 0) {
            for (Server server : servers) {
                if (remainingLoad <= 0) {
                    break;
                }
                double loadToAdd = Math.min(remainingLoad, server.getMaxLoad() - server.getLoad());
                server.setLoad(server.getLoad() + loadToAdd);
                remainingLoad -= loadToAdd;
            }
        }
    }
}
