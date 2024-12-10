package school.faang.task_45018;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.faang.task_45018.DataInitializerUtils.initDataCenter;

class EnergyEfficiencyOptimizationStrategyTest {
    private final DataCenter dataCenter = new DataCenter(initDataCenter());
    private final DataCenterService dataCenterService = new DataCenterService(dataCenter,
            new EnergyEfficiencyOptimizationStrategy());

    @Test
    void shouldOptimize() {
        dataCenterService.optimize(dataCenter);

        double expectedEnergyConsumption = 4;
        double actualEnergyConsumption = dataCenter.getServers().get(0).getEnergyConsumption();
        assertEquals(expectedEnergyConsumption, actualEnergyConsumption);
    }
}