package school.faang.sprint_1.task_45040;

import java.util.Comparator;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        dataCenter.getServers().stream()
                .filter(server -> server.getLoad() > 0)
                .sorted(Comparator.comparingDouble(Server::getEnergyConsumption))
                .forEach(server -> {
                    if (server.getLoad() > 0) {
                        double loadToDistribute = server.getLoad() / 2;
                        server.removeLoad(loadToDistribute);
                    }
                });
    }
}


