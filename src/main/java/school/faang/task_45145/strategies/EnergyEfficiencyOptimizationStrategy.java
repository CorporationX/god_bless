package school.faang.task_45145.strategies;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_45145.models.DataCenter;
import school.faang.task_45145.models.Server;

@Slf4j
public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        final String dataCenterName = dataCenter.getName();
        log.info("Starting energy efficiency optimization strategy for Data Center '{}'", dataCenterName);

        for (Server server : dataCenter.getServers()) {
            final String serverName = server.getName();
            log.debug("Server '{}' energy consumption: {}", serverName, server.getEnergyConsumption());

            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0);
                log.debug("Server '{}' has zero load. Energy consumption set to 0.", serverName);
            }
        }
        log.info("Energy efficiency optimization strategy completed for Data Center '{}'", dataCenterName);
    }
}
