package faang.school.godbless.task_13;

import faang.school.godbless.task_13.optimization.LoadBalancingOptimization;
import faang.school.godbless.task_13.optimization.OptimizationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataCenterServiceTest {
    private DataCenterService service;
    private OptimizationStrategy optimizationStrategy;
    private Server server1, server2, server3;

    @BeforeEach
    void setUp() {
        List<Server> servers = new ArrayList<>();
        server1 = new Server(2, 2, 2);
        server2 = new Server(8, 10, 8);
        server3 = new Server(96, 200, 96);
        servers.add(server1);
        servers.add(server2);
        servers.add(server3);
        DataCenter dataCenter = new DataCenter(servers);
        service = new DataCenterService(dataCenter);
        optimizationStrategy = new LoadBalancingOptimization();
    }

    @Test
    void addServer() {
        service.addServer(new Server(0, 0, 0));
        assertEquals(4, service.getAllServers().size());
    }

    @Test
    void removeServer() {
        service.removeServer(server1);
        assertEquals(2, service.getAllServers().size());
    }

    @Test
    void getTotalEnergyConsumption() {
        assertEquals(106, service.getTotalEnergyConsumption());
    }

    @Test
    void allocateResources() {
        boolean success = service.allocateResources(new ResourceRequest(50));
        assertTrue(success);
        assertEquals(146, server3.getLoad());
    }

    @Test
    void allocateResourcesEmptyServers() {
        service.removeServer(server1);
        service.removeServer(server2);
        service.removeServer(server3);
        boolean success = service.allocateResources(new ResourceRequest(50));
        assertFalse(success);
    }

    @Test
    void allocateResourcesTooBigRequestLoad() {
        boolean success = service.allocateResources(new ResourceRequest(105));
        assertFalse(success);
    }

    @Test
    void releaseResources() {
        boolean success = service.releaseResources(new ResourceRequest(50));
        assertTrue(success);
        assertEquals(46, server3.getLoad());
    }

    @Test
    void releaseResourcesEmptyServers() {
        service.removeServer(server1);
        service.removeServer(server2);
        service.removeServer(server3);
        boolean success = service.releaseResources(new ResourceRequest(50));
        assertFalse(success);
    }

    @Test
    void releaseResourcesTooBigRequestLoad() {
        boolean success = service.releaseResources(new ResourceRequest(97));
        assertFalse(success);
    }

    @Test
    void optimize() {
        service.optimize(optimizationStrategy);
        assertEquals(1, server1.getLoad());
        assertEquals(5, server2.getLoad());
        assertEquals(100, server3.getLoad());
    }
}