package school.faang.task_45018;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static school.faang.task_45018.DataInitializerUtils.initDataCenter;

class LoadBalancingOptimizationStrategyTest {
    private final DataCenter dataCenter = new DataCenter(initDataCenter());
    private final DataCenterService dataCenterService = new DataCenterService(dataCenter,
            new LoadBalancingOptimizationStrategy());

    @Test
    void shouldOptimize() {
        dataCenterService.optimize();

        double expectedLoad = 2.5;
        double actualLoad = dataCenter.getDataCenters().get(0).getLoad();
        assertEquals(expectedLoad, actualLoad);
    }
}