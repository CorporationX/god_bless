package school.faang.sprint_1.task_45025.optimization.impl;

import school.faang.sprint_1.task_45025.data_center.DataCenter;
import school.faang.sprint_1.task_45025.exceptions.LoadOverflowException;
import school.faang.sprint_1.task_45025.optimization.OptimizationStrategy;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) throws LoadOverflowException {
        for (var server : dataCenter.getServers()) {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0);
            }
        }
    }
}
