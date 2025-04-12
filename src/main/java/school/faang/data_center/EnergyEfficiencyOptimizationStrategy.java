package school.faang.data_center;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0.0); // Отключаем сервер
            }
        }
        log.info("Servers without loads were disabled");
    }
}
