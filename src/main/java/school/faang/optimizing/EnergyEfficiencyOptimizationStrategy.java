package school.faang.optimizing;

import lombok.Data;

@Data
public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0.0);
            } else {
                server.setEnergyConsumption(server.getLoad() * 0.4);
            }
        }
    }
}
