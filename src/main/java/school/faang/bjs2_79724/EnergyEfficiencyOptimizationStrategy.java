package school.faang.bjs2_79724;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = new ArrayList<>(dataCenter.getServers());
        servers.sort(Comparator.comparingDouble(Server::getMaxLoad).reversed());

        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        for (Server server : servers) {
            if (totalLoad <= 0) {
                server.setLoad(0);
                server.setEnergyConsumption(0);
                continue;
            }

            double loadToAssign = Math.min(server.getMaxLoad(), totalLoad);
            server.setLoad(loadToAssign);
            server.setEnergyConsumption(loadToAssign * 1.5);
            totalLoad -= loadToAssign;
        }
    }
}
