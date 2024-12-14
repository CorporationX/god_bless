package school.faang.bjs245016.optimizationstrategies;

import school.faang.bjs245016.DataCenter;
import school.faang.bjs245016.OptimizationStrategy;
import school.faang.bjs245016.Server;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter datacenter) {
        System.out.println("Energy efficient optimization flow");

        datacenter.getServersList().forEach(server -> {
            if (server.getLoad() == 0) {
                server.shutDown();
            }
        });
    }
}
