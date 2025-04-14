package school.faang.bjs2_69892;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EnergyBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> sortedServers = new ArrayList<>(dataCenter.getServers());
        sortedServers.sort(Comparator.comparingDouble(Server::getMaxLoad).reversed());
        double totalLoad = dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
        for (Server server : sortedServers) {
            if (totalLoad == 0) {
                server.setLoad(0);
            }
            double minServerLoad = Math.min(totalLoad, server.getMaxLoad());
            server.setLoad(minServerLoad);
            totalLoad -= minServerLoad;
        }
    }
}
