package service;

import faang.school.godbless.BJS2_19800.model.ResourceRequest;
import faang.school.godbless.BJS2_19800.model.Server;
import faang.school.godbless.BJS2_19800.service.DataCenterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataCenterServiceTest {
    private DataCenterService dataCenterService;
    private Server server1;
    private Server server2;

    @BeforeEach
    public void setUp() {
        dataCenterService = new DataCenterService();
        server1 = new Server(100, 50);
        server2 = new Server(150, 75);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
    }

    @Test
    public void testAddServer() {
        Server server3 = new Server(200, 100);
        dataCenterService.addServer(server3);
        assertTrue(dataCenterService.getDataCenter().getServerList().contains(server3));
    }

    @Test
    public void testRemoveServer() {
        dataCenterService.removeServer(server1);
        assertFalse(dataCenterService.getDataCenter().getServerList().contains(server1));
    }

    @Test
    public void testGetTotalEnergyConsumption() {
        assertEquals(125, dataCenterService.getTotalEnergyConsumption());
    }

    @Test
    public void testAllocateResources() {
        ResourceRequest resourceRequest = new ResourceRequest(50);
        dataCenterService.allocateResources(resourceRequest);
        assertEquals(50, server1.getLoad());
    }

    @Test
    public void testReleaseResources() {
        server1.setLoad(50);
        ResourceRequest resourceRequest = new ResourceRequest(30);
        dataCenterService.releaseResources(resourceRequest);
        assertEquals(20, server1.getLoad());
    }
}
