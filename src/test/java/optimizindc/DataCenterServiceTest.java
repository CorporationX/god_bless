package optimizindc;

import org.junit.jupiter.api.Test;
import school.faang.optimizingdc.DataCenter;
import school.faang.optimizingdc.DataCenterService;
import school.faang.optimizingdc.LoadBalancingOptimizationStrategy;
import school.faang.optimizingdc.ResourceRequest;
import school.faang.optimizingdc.Server;

import static org.junit.jupiter.api.Assertions.*;

public class DataCenterServiceTest {
    @Test
    public void testAddAndRemoveServer() {
        DataCenter dataCenter = new DataCenter();
        DataCenterService service = new DataCenterService(dataCenter, new LoadBalancingOptimizationStrategy());

        Server server1 = new Server(0, 100, 50);
        Server server2 = new Server(0, 200, 75);

        service.addServer(server1);
        service.addServer(server2);

        assertEquals(2, dataCenter.getServers().size());

        service.removeServer(server1);
        assertEquals(1, dataCenter.getServers().size());
    }

    @Test
    public void testResourceAllocation() {
        DataCenter dataCenter = new DataCenter();
        DataCenterService service = new DataCenterService(dataCenter, new LoadBalancingOptimizationStrategy());

        Server server1 = new Server(20, 100, 50);
        service.addServer(server1);

        ResourceRequest request = new ResourceRequest(30);
        boolean allocated = service.allocateResources(request);

        assertTrue(allocated);
        assertEquals(50, server1.getLoad());
    }

    @Test
    public void testLoadBalancingOptimization() {
        DataCenter dataCenter = new DataCenter();
        DataCenterService service = new DataCenterService(dataCenter, new LoadBalancingOptimizationStrategy());

        Server server1 = new Server(80, 100, 50);
        Server server2 = new Server(20, 100, 60);
        service.addServer(server1);
        service.addServer(server2);

        service.optimizeDataCenter();

        assertEquals(50, server1.getLoad());
        assertEquals(50, server2.getLoad());
    }
}
