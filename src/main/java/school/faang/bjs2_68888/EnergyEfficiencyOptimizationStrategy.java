package school.faang.bjs2_68888;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    public void optimize(DataCenter dataCenter) {
        for (Server server : dataCenter.servers) {
            if (server.getLoad() == 0.0) {
                server.setEnergyConsumption(0);
                log.info("Sever {} is shot down.", server);
            }
        }
    }
}
