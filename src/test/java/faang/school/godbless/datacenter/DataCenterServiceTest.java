package faang.school.godbless.datacenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {
    private DataCenterService dataCenterService;
    private DataCenter dataCenter;

    @BeforeEach
    public void setUp() {
        dataCenter = new DataCenter();
        dataCenterService = new DataCenterService(dataCenter);
    }

    @Test
    public void testAddServer() {
        Server server = new Server(10, 100, 50);
        dataCenterService.addServer(server);

        assertTrue(dataCenter.getServersList().contains(server));
    }

    @Test
    public void testRemoveServerFail() {
        Server server = new Server(10, 100, 50);
        dataCenterService.addServer(server);

        assertThrows(RuntimeException.class, () -> {
            dataCenterService.removeServer(server, false);
        });
    }

    @Test
    public void testGetTotalEnergyConsumption() {
        Server server1 = new Server(10, 100, 50);
        Server server2 = new Server(20, 200, 100);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);

        double totalEnergy = dataCenterService.getTotalEnergyConsumption();
        assertEquals(150, totalEnergy, 0.01);
    }

    @Test
    public void testAllocateResources() {
        DataCenter dataCenter = new DataCenter();
        DataCenterService service = new DataCenterService(dataCenter);

        Server server1 = new Server(0, 100, 50);
        Server server2 = new Server(0, 200, 70);
        service.addServer(server1);
        service.addServer(server2);

        ResourceRequest request = new ResourceRequest(150);
        service.allocateResources(request);

        assertEquals(100, server1.getLoad(), 0.01);
        assertEquals(50, server2.getLoad(), 0.01);
    }

    @Test
    public void testReleaseResources() {
        DataCenter dataCenter = new DataCenter();
        DataCenterService service = new DataCenterService(dataCenter);

        Server server1 = new Server(100, 100, 50);
        Server server2 = new Server(100, 200, 70);
        service.addServer(server1);
        service.addServer(server2);

        ResourceRequest request = new ResourceRequest(150);
        service.releaseResources(request);

        assertEquals(0, server1.getLoad());
        assertEquals(50, server2.getLoad());
    }


    @Test
    public void testOptimize() {
        Server server1 = new Server(100, 200, 50);
        Server server2 = new Server(0, 200, 50);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);

        dataCenterService.optimize();

        assertEquals(50, server1.getLoad(), 0.01);
        assertEquals(50, server2.getLoad(), 0.01);
    }
}