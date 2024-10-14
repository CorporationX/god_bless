package school.faang.optimizingdc;

import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        // Sort servers by load in descending order
        servers.sort((s1, s2) -> Double.compare(s2.getLoad(), s1.getLoad()));

        // Consolidate load onto fewer servers to minimize energy consumption
        double totalLoad = 0;
        for (Server server : servers) {
            totalLoad += server.getLoad();
            server.setLoad(0);
        }

        for (Server server : servers) {
            if (totalLoad > 0 && totalLoad >= server.getMaxLoad()) {
                server.setLoad(server.getMaxLoad());
                totalLoad -= server.getMaxLoad();
            } else {
                server.setLoad(totalLoad);
                break;
            }
        }

        System.out.println("Energy efficiency optimization complete.");
    }
}

