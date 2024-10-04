package school.faang.t10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DataCenterServiceTest {
    private DataCenter dataCenter;
    private DataCenterService service;
    private Server server1;
    private Server server2;

    @BeforeEach
    void setUp() {
        dataCenter = new DataCenter();
        server1 = new Server(100);
        server2 = new Server(200);
        dataCenter.addServer(server1);
        dataCenter.addServer(server2);
        service = new DataCenterService(dataCenter, new LoadBalancingOptimizationStrategy());
    }


    @Test
    @DisplayName("Add server test")
    void testAddServer() {
        Server newServer = new Server(150);
        service.addServer(newServer);
        assertTrue(dataCenter.getServers().contains(newServer));
        assertEquals(3, dataCenter.getServers().size());
    }

    @Test
    @DisplayName("Remove server test")
    void testRemoveServer() {
        service.removeServer(server1);
        assertFalse(dataCenter.getServers().contains(server1));
        assertEquals(1, dataCenter.getServers().size());
    }

    @Test
    @DisplayName("Total Energy Consumption test")
    void testGetTotalEnergyConsumption() {
        // Устанавливаем нагрузку
        server1.setLoad(50);
        server2.setLoad(100);

        double expectedTotalConsumption = 200.0;
        assertEquals(expectedTotalConsumption, service.getTotalEnergyConsumption(), 0.01);
    }

    @Test
    @DisplayName("Allocate Resources test")
    void testAllocateResources() {
        assertTrue(service.allocateResources(new ResourceRequest(80)));
        assertEquals(80, server1.getLoad());
        assertTrue(service.allocateResources(new ResourceRequest(150)));
        assertEquals(80, server1.getLoad());
        assertEquals(150, server2.getLoad());
        assertFalse(service.allocateResources(new ResourceRequest(200)));
    }

    @Test
    @DisplayName("Release Resources test")
    void testReleaseResources() {
        server1.setLoad(80);
        server2.setLoad(150);
        assertTrue(service.releaseResources(new ResourceRequest(30)));
        assertEquals(50, server1.getLoad());
        assertTrue(service.releaseResources(new ResourceRequest(100)));
        assertEquals(50, server1.getLoad());
        assertEquals(50, server2.getLoad());
        assertFalse(service.releaseResources(new ResourceRequest(200)));
    }
}