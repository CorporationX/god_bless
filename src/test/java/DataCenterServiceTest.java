import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.optimization.DataCenter;
import school.faang.optimization.DataCenterService;
import school.faang.optimization.EnergyEfficiencyOptimizationStrategy;
import school.faang.optimization.LoadBalancingOptimizationStrategy;
import school.faang.optimization.OptimizationStrategy;
import school.faang.optimization.ResourceRequest;
import school.faang.optimization.Server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataCenterServiceTest {

    private DataCenter dataCenter;
    private DataCenterService service;

    @BeforeEach
    void setUp() {
        dataCenter = new DataCenter();
        service = new DataCenterService();
    }

    @Test
    void testAddAndRemoveServer() {
        System.out.println("--- Test: Adding and removing a server ---");

        Server server = new Server(0, 100, 50);
        service.addServer(dataCenter, server);
        assertEquals(1, dataCenter.getServers().size());
        System.out.printf("The server has been added. Number of servers: %s%n", dataCenter.getServers().size());

        service.removeServer(dataCenter, server);
        assertEquals(0, dataCenter.getServers().size());
        System.out.printf("The server has been deleted. Number of servers: %s%n", dataCenter.getServers().size());

    }

    @Test
    void testAllocateResources() {
        System.out.println("--- Test: Load Balancing ---");

        Server server1 = new Server(0, 100, 50);
        Server server2 = new Server(0, 100, 50);
        service.addServer(dataCenter, server1);
        service.addServer(dataCenter, server2);

        ResourceRequest request = new ResourceRequest(150);
        assertTrue(service.allocateResources(dataCenter, request));
        System.out.println("The load is distributed:");
        System.out.printf("Server 1: load = %s%n", server1.getLoad());
        System.out.printf("Server 2: load = %s%n", server2.getLoad());

        assertEquals(100, server1.getLoad());
        assertEquals(50, server2.getLoad());

    }

    @Test
    void testReleaseResources() {
        System.out.println("--- Test: Resource Release ---");

        Server server1 = new Server(100, 100, 50);
        Server server2 = new Server(50, 100, 50);
        service.addServer(dataCenter, server1);
        service.addServer(dataCenter, server2);

        ResourceRequest request = new ResourceRequest(100);
        service.releaseResources(dataCenter, request);
        System.out.println("Resources have been released:");
        System.out.printf("Server 1: load = %s%n", server1.getLoad());
        System.out.printf("Server 2: load = %s%n", server2.getLoad());

        assertEquals(0, server1.getLoad());
        assertEquals(50, server2.getLoad());

    }

    @Test
    void testLoadBalancingOptimization() {
        System.out.println("--- Test: Load Balancing Optimization ---");

        Server server1 = new Server(80, 100, 50);
        Server server2 = new Server(20, 100, 50);
        service.addServer(dataCenter, server1);
        service.addServer(dataCenter, server2);

        OptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();
        service.optimize(dataCenter, strategy);
        System.out.println("Load after optimization:");
        System.out.printf("Server 1: load = %s%n", server1.getLoad());
        System.out.printf("Server 2: load = %s%n", server2.getLoad());

        assertEquals(50, server1.getLoad());
        assertEquals(50, server2.getLoad());

    }

    @Test
    void testEnergyEfficiencyOptimization() {
        System.out.println("--- Test: Optimization of energy consumption ---");

        Server server1 = new Server(50, 100, 30);
        Server server2 = new Server(50, 100, 50);
        service.addServer(dataCenter, server1);
        service.addServer(dataCenter, server2);

        OptimizationStrategy strategy = new EnergyEfficiencyOptimizationStrategy();
        service.optimize(dataCenter, strategy);
        System.out.println("Load after optimization:");
        System.out.printf("Server 1: load = %s%n", server1.getLoad());
        System.out.printf("Server 2: load = %s%n", server2.getLoad());

        assertEquals(100, server1.getLoad());
        assertEquals(0, server2.getLoad());

    }
}
