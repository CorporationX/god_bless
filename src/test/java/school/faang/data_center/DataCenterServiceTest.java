package school.faang.data_center;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataCenterServiceTest {
    private DataCenterService centerService;
    private DataCenter dataCenter;

    @BeforeEach
    public void setUp() {
        centerService = new DataCenterService();
        dataCenter = new DataCenter();
    }

    public void addServers() {
        Server server1 = new Server(1, 15);
        centerService.addServer(dataCenter, server1);
        Server server2 = new Server(2, 17);
        centerService.addServer(dataCenter, server2);
        Server server3 = new Server(3, 14);
        centerService.addServer(dataCenter, server3);
        Server server4 = new Server(4, 16);
        centerService.addServer(dataCenter, server4);
    }

    @Test
    public void testAddServer() {
        Server server1 = new Server(1, 15);
        centerService.addServer(dataCenter, server1);
        Server server2 = new Server(2, 17);
        centerService.addServer(dataCenter, server2);
        Server server3 = new Server(3, 14);
        centerService.addServer(dataCenter, server3);
        Server server4 = new Server(4, 16);
        centerService.addServer(dataCenter, server4);
        assertTrue(dataCenter.getServerList().contains(server1));
        assertTrue(dataCenter.getServerList().contains(server2));
        assertTrue(dataCenter.getServerList().contains(server3));
        assertTrue(dataCenter.getServerList().contains(server4));
    }

    @Test
    public void testAllocateResources() {
        addServers();
        ResourceRequest request = new ResourceRequest(37);
        boolean allocated = centerService.allocateResources(dataCenter, request);
        assertTrue(allocated);
    }

    @Test
    public void testReleaseResources() {
        addServers();
        dataCenter.getServerList().forEach(server -> {
            server.setLoad(10);
        });
        ResourceRequest request = new ResourceRequest(37);
        centerService.releaseResources(dataCenter, request);
        double load = 0.0;
        for (Server server : dataCenter.getServerList()) {
            load += server.getLoad();
        }
        assertEquals(load, 3.0);
    }

    @Test
    public void testOptimize() {
        addServers();
        dataCenter.getServerList().forEach(server -> {
            server.setLoad(14);
        });

        Server server = new Server(5, 7);
        centerService.addServer(dataCenter, server);
        centerService.setStrategy(new LoadBalancedOptimizationStrategy());
        assertTrue(server.getLoad() == 0.0);
        centerService.optimize(dataCenter);
        assertTrue(server.getLoad() > 0.0);
    }
}
