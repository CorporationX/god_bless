package faang.school.godbless.optimizing.work;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataCenterServiceTest {

    @Test
    @DisplayName("Проверка оптимизации")
    public void testOptimize() {
        DataCenter dataCenter = new DataCenter();
        LoadBalancingOptimizationStrategy loadBalancingOptimizationStrategy = new LoadBalancingOptimizationStrategy();
        DataCenterService service = new DataCenterService(dataCenter, loadBalancingOptimizationStrategy);

        Server server1 = new Server(0, 100, 10);
        Server server2 = new Server(0, 200, 20);
        service.addServer(server1);
        service.addServer(server2);

        service.allocateResources(new ResourceRequest(100));
        service.optimize();

        assertEquals(50, server1.getLoad(), 0.01);
        assertEquals(50, server2.getLoad(), 0.01);
    }

}