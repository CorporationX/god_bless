package school.faang.module1.bjs2_79747;

import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy{

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        if (servers == null || servers.isEmpty()) {
            return;
        }
        servers.forEach(server -> {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0);
            }
        });
    }
}