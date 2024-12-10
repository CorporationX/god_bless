package school.faang.task45030.strategy;

import school.faang.task45030.model.DataCenter;
import school.faang.task45030.model.Server;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        {
            for (Server server : dataCenter.getServerList()) {
                if (server.getLoad() == 0) {
                    server.setEnergyConsumption(0);
                }
            }
        }
    }
}
