package school.faang;

import java.util.Comparator;
import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        servers.sort(Comparator.comparingDouble(Server::getEnergyConsumption));
        distributeLoad(servers);
        servers.sort(Comparator.comparingDouble(Server::getEnergyConsumption).reversed());
        distributeLoad(servers);

        for (Server server : servers) {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0.0);
            }
        }
    }

    private void distributeLoad(List<Server> servers) {
        for (int first = 0, last = servers.size() - 1; first < last; first++) {
            Server firstServer = servers.get(first);
            for (; firstServer.getLoad() > 0 && first < last; last--) {
                Server lastServer = servers.get(last);
                double take = Math.min(firstServer.getLoad(), lastServer.getMaxLoad() - lastServer.getLoad());
                lastServer.setLoad(lastServer.getLoad() + take);
                firstServer.setLoad(firstServer.getLoad() - take);
            }
        }
    }
}
