package school.faang.bjs245016.optimizationstrategies;

import school.faang.bjs245016.DataCenter;
import school.faang.bjs245016.OptimizationStrategy;
import school.faang.bjs245016.Server;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter datacenter) {
        System.out.println("Energy efficient optimization flow");
        for (Server server : datacenter.getServersList()) {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0); // Отключаем сервер для экономии энергии
            }
        }
    }
}
