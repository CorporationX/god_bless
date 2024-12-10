package school.faang.sprint_1.task_45026.strategy;

import school.faang.sprint_1.task_45026.repository.DataCenter;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter == null) {
            throw new IllegalArgumentException("Data center is null");
        }

        dataCenter.getServers()
                .stream()
                .filter(server -> server.getLoad() == 0)
                .forEach(server -> server.setEnergyConsumption(0));
    }
}
