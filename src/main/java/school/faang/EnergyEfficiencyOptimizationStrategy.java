package school.faang;

import java.util.Comparator;
import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.servers;
        servers.sort(Comparator.comparingDouble(Server::getEnergyConsumption));
        distributeLoad(dataCenter, servers);
        servers.sort(Comparator.comparingDouble(Server::getEnergyConsumption).reversed());
        distributeLoad(dataCenter, servers);

        for (Server server : servers) {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0.0);
            }
        }
    }

    private void distributeLoad(DataCenter dataCenter, List<Server> servers) {
        for (int first = 0, last = servers.size() - 1; first < last; first++) {
            Server firstServer = servers.get(first);
            if (!canDistributeLoad(dataCenter, first, last)) {
                break;
            }
            for (; firstServer.getLoad() > 0 && first < last; last--) {
                Server lastServer = servers.get(last);
                double take = Math.min(firstServer.getLoad(), lastServer.getMaxLoad() - lastServer.getLoad());
                lastServer.setLoad(lastServer.getLoad() + take);
                firstServer.setLoad(firstServer.getLoad() - take);
            }
        }
    }

    private boolean canDistributeLoad(DataCenter dataCenter, int first, int last) {
        double distributedLoad = 0;
        List<Server> servers = dataCenter.servers;
        for (; first < last; --last) {
            Server lastServer = servers.get(last);
            distributedLoad += lastServer.getMaxLoad() - lastServer.getLoad();
        }
        return distributedLoad >= servers.get(first).getLoad();
    }
}
