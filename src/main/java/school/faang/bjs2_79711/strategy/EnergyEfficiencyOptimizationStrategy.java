package school.faang.bjs2_79711.strategy;

import school.faang.bjs2_79711.DataCenter;
import school.faang.bjs2_79711.Server;
import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        servers.forEach(server -> {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0);
            }
        });
    }
}
