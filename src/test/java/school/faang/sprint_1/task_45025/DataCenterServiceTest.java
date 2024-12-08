package school.faang.sprint_1.task_45025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.sprint_1.task_45025.data_center.DataCenterService;
import school.faang.sprint_1.task_45025.exceptions.LoadNotEnoughException;
import school.faang.sprint_1.task_45025.models.ResourceRequest;
import school.faang.sprint_1.task_45025.models.Server;
import school.faang.sprint_1.task_45025.optimization.impl.EnergyEfficiencyOptimizationStrategy;
import school.faang.sprint_1.task_45025.optimization.impl.LoadBalancingOptimizationStrategy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataCenterServiceTest {
    DataCenterService dataCenterService;

    @BeforeEach
    void setUp() {
        dataCenterService = new DataCenterService();
    }

    @Test
    void testAddServer() {
        Server server = new Server(10, 100, 20);

        dataCenterService.addServer(server);

        assertTrue(dataCenterService.getServers().contains(server));
    }

    @Test
    void testRemoveServer() {
        Server server = new Server(10, 100, 20);
        dataCenterService.addServer(server);

        dataCenterService.removeServer(server);

        assertFalse(dataCenterService.getServers().contains(server));
    }

    @Test
    void testGetTotalEnergyConsumption() {
        double server1EnergyConsumption = 20;
        double server2EnergyConsumption = 30;
        Server server1 = new Server(10, 100, server1EnergyConsumption);
        Server server2 = new Server(10, 100, server2EnergyConsumption);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);

        var totalEnergyConsumption = dataCenterService.getTotalEnergyConsumption();

        assertEquals(server1EnergyConsumption + server2EnergyConsumption, totalEnergyConsumption);
    }

    @Test
    void testAllocateResourcesSuccess() {
        Server server1 = new Server(70, 100, 20);
        Server server2 = new Server(90, 100, 30);
        Server server3 = new Server(85, 100, 30);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);
        ResourceRequest request = new ResourceRequest(50);

        assertDoesNotThrow(() -> dataCenterService.allocateResources(request));
        assertEquals(100, server1.getLoad());
        assertEquals(100, server2.getLoad());
        assertEquals(95, server3.getLoad());
    }

    @Test
    void testAllocateResourcesNotEnoughLoad() {
        Server server1 = new Server(70, 100, 20);
        Server server2 = new Server(90, 100, 30);
        Server server3 = new Server(95, 100, 30);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);
        ResourceRequest request = new ResourceRequest(50);

        assertThrows(LoadNotEnoughException.class, () -> dataCenterService.allocateResources(request));
    }

    @Test
    void testReleaseResources() {
        Server server1 = new Server(10, 100, 20);
        Server server2 = new Server(20, 100, 30);
        Server server3 = new Server(30, 100, 30);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);
        ResourceRequest request = new ResourceRequest(50);

        dataCenterService.releaseResources(request);

        assertEquals(0, server1.getLoad());
        assertEquals(0, server2.getLoad());
        assertEquals(10, server3.getLoad());
    }

    @Test
    void testOptimizeLoadBalancerWithDifferentMaxLoad() {
        Server server1 = new Server(30, 100, 20);
        Server server2 = new Server(140, 200, 30);
        Server server3 = new Server(210, 300, 30);
        LoadBalancingOptimizationStrategy optimizationStrategy = new LoadBalancingOptimizationStrategy();
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);

        dataCenterService.optimize(optimizationStrategy);

        assertEquals(64, server1.getLoad());
        assertEquals(126, server2.getLoad());
        assertEquals(190, server3.getLoad());
    }

    @Test
    void testOptimizeLoadBalancerWithSameMaxLoad() {
        Server server1 = new Server(10, 100, 20);
        Server server2 = new Server(50, 100, 30);
        Server server3 = new Server(30, 100, 30);
        LoadBalancingOptimizationStrategy optimizationStrategy = new LoadBalancingOptimizationStrategy();
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);

        dataCenterService.optimize(optimizationStrategy);

        assertEquals(30, server1.getLoad());
        assertEquals(30, server2.getLoad());
        assertEquals(30, server3.getLoad());
    }

    @Test
    void testEnergyEfficiency() {
        Server server1 = new Server(10, 100, 20);
        Server server2 = new Server(0, 100, 30);
        EnergyEfficiencyOptimizationStrategy optimizationStrategy = new EnergyEfficiencyOptimizationStrategy();
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);

        dataCenterService.optimize(optimizationStrategy);

        assertEquals(20, server1.getEnergyConsumption());
        assertEquals(0, server2.getEnergyConsumption());
    }
}
