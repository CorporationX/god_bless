package school.faang.datacenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDataCenterService {

    private DataCenterService dataCenterService;
    private DataCenter dataCenter;

    @BeforeEach
    public void setUp() {
        dataCenterService = new DataCenterService(new LoadBalancingOptimizationStrategy());
        dataCenter = new DataCenter(new ArrayList<>());
    }

    @Test
    public void testAddServer() {
        Server firstServer = new Server(100, 500, 20);
        Server secondServer = new Server(200, 500, 40);

        dataCenterService.addServer(dataCenter, firstServer);
        dataCenterService.addServer(dataCenter, secondServer);

        assertEquals(2, dataCenter.servers().size(), "Must be equal");
    }

    @Test
    public void removeServer() {
        Server firstServer = new Server(100, 500, 20);
        Server secondServer = new Server(200, 500, 40);

        dataCenterService.addServer(dataCenter, firstServer);
        dataCenterService.addServer(dataCenter, secondServer);

        dataCenterService.removeServer(dataCenter, secondServer);

        assertEquals(1, dataCenter.servers().size(), "Must be equal");
    }

    @Test
    public void testGetTotalEnergyConsumption() {
        Server firstServer = new Server(100, 500, 20);
        Server secondServer = new Server(200, 500, 40);

        dataCenterService.addServer(dataCenter, firstServer);
        dataCenterService.addServer(dataCenter, secondServer);

        double totalEnergyConsumption = dataCenterService.getTotalEnergyConsumption(dataCenter);

        assertEquals(60, totalEnergyConsumption, "Must be equal");
    }

    @Test
    public void testAllocateResourcesSuccessfully() {
        Server firstServer = new Server(100, 500, 20);
        Server secondServer = new Server(200, 500, 40);

        dataCenterService.addServer(dataCenter, firstServer);
        dataCenterService.addServer(dataCenter, secondServer);

        ResourceRequest request = new ResourceRequest(200);

        boolean allocationSuccessful = dataCenterService.allocateResources(dataCenter, request);

        assertTrue(allocationSuccessful, "Resources must be allocated");
    }

    @Test
    public void testAllocateResourcesUnsuccessfully() {
        Server firstServer = new Server(100, 500, 20);
        Server secondServer = new Server(200, 500, 40);

        dataCenterService.addServer(dataCenter, firstServer);
        dataCenterService.addServer(dataCenter, secondServer);

        ResourceRequest request = new ResourceRequest(1000);

        boolean allocationSuccessful = dataCenterService.allocateResources(dataCenter, request);

        assertFalse(allocationSuccessful, "Resources must not be allocated");
    }

    @Test
    public void testReleaseResources() {
        Server firstServer = new Server(100, 500, 20);
        Server secondServer = new Server(200, 500, 40);

        dataCenterService.addServer(dataCenter, firstServer);
        dataCenterService.addServer(dataCenter, secondServer);

        ResourceRequest request = new ResourceRequest(150);

        dataCenterService.releaseResources(dataCenter, request);

        assertEquals(0, firstServer.getLoad(), "Must be equal");
        assertEquals(150, secondServer.getLoad(), "Must be equal");
    }
}
