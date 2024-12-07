package school.faang.task_45026.strategy;

import school.faang.task_45026.entity.Server;
import school.faang.task_45026.repository.DataCenter;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter == null) {
            throw new IllegalArgumentException("Data center is null");
        }

        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0);
            }
        }
    }
}
