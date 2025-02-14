package school.faang.optimizing_data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataCenterServiceTest {

    private DataCenter dataCenter;
    private Server server1;

    @BeforeEach
    public void setUp() {
        dataCenter = new DataCenter();
        server1 = new Server(50, 100, 200);
    }

    @Test
    public void testAddServer() {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(dataCenter, server1);

        assertEquals(1, dataCenter.getServers().size());
        assertTrue(dataCenter.getServers().contains(server1));
    }

    @Test
    public void testRemoveServer() {
        dataCenter.addServer(server1);
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.removeServer(dataCenter, server1);

        assertEquals(0, dataCenter.getServers().size());
        assertFalse(dataCenter.getServers().contains(server1));
    }

    @Test
    public void testGetTotalEnergyConsumption() {
        Server server2 = new Server(30, 100, 150);
        dataCenter.addServer(server1);
        dataCenter.addServer(server2);

        DataCenterService dataCenterService = new DataCenterService();
        double totalEnergy = dataCenterService.getTotalEnergyConsumption(dataCenter);

        assertEquals(350, totalEnergy);
    }

    @Test
    public void testAllocateResources() {
        dataCenter.addServer(server1);
        ResourceRequest request = new ResourceRequest(20);
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.allocateResources(dataCenter, request);

        assertEquals(70, server1.getLoad());
    }

    @Test
    public void testReleaseResources() {
        server1.setLoad(70);
        dataCenter.addServer(server1);
        ResourceRequest request = new ResourceRequest(30);
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.releaseResources(dataCenter, request);

        assertEquals(40, server1.getLoad());
    }

    @Test
    public void testApplyLoadBalancingOptimizationStrategy() {
        Server server2 = new Server(45, 100, 150);
        Server server3 = new Server(85, 100, 180);
        dataCenter.addServer(server1);
        dataCenter.addServer(server2);
        dataCenter.addServer(server3);

        LoadBalancingOptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.applyOptimizationStrategy(dataCenter, strategy);

        assertEquals(60, server1.getLoad());
        assertEquals(60, server2.getLoad());
        assertEquals(60, server3.getLoad());
    }

    @Test
    public void testApplyEnergyEfficiencyOptimizationStrategy() {
        Server server2 = new Server(30, 100, 150);
        dataCenter.addServer(server1);
        dataCenter.addServer(server2);

        EnergyEfficiencyOptimizationStrategy strategy = new EnergyEfficiencyOptimizationStrategy();
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.applyOptimizationStrategy(dataCenter, strategy);

        assertEquals(50, server1.getLoad());
        assertEquals(80, server2.getLoad());
    }
}