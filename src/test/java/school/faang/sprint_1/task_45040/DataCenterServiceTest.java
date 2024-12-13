package school.faang.sprint_1.task_45040;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {
    private DataCenterService service;
    private DataCenter dataCenter;

    @BeforeEach
    void setUp() {
        dataCenter = new DataCenter();
        service = new DataCenterService(dataCenter, new LoadBalancingOptimizationStrategy());
    }

    @Test
    void testAddServer() {
        Server server = new Server(100, 50);
        service.addServer(server);
        assertEquals(1, dataCenter.getServers().size());
    }

    @Test
    void testAllocateResources() {
        Server server = new Server(100, 50);
        service.addServer(server);
        ResourceRequest request = new ResourceRequest(70);
        service.allocateResources(request);
        assertEquals(70, server.getLoad());
    }

    @Test
    void testReleaseResources() {
        Server server = new Server(100, 50);
        service.addServer(server);
        ResourceRequest request = new ResourceRequest(70);
        service.allocateResources(request);
        service.releaseResources(request);
        assertEquals(0, server.getLoad());
    }

    @Test
    void testOptimization() {
        Server server1 = new Server(100, 50);
        Server server2 = new Server(100, 40);
        service.addServer(server1);
        service.addServer(server2);
        ResourceRequest request = new ResourceRequest(150);
        service.allocateResources(request);

        service.optimize();
        assertTrue(server1.getLoad() < 150 && server2.getLoad() < 150);
    }
}