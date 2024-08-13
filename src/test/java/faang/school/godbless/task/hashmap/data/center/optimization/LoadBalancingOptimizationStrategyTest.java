package faang.school.godbless.task.hashmap.data.center.optimization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadBalancingOptimizationStrategyTest {
    private Server server1 = new Server();
    private Server server2 = new Server();
    private Server server3 = new Server();
    private List<Server> servers;

    private LoadBalancingOptimizationStrategy loadBalancing;
    private DataCenterService dataCenterService;

    @BeforeEach
    void setUp() {
        servers = new ArrayList<>(List.of(server1, server2, server3));

        loadBalancing = new LoadBalancingOptimizationStrategy();
        dataCenterService = new DataCenterService(new DataCenter(new LinkedList<>()), loadBalancing);
        servers.forEach(srvr -> dataCenterService.addNewServer(srvr));
    }

    @Test
    void testGetTotalLoad() {
        server1.allocateLoad(50);
        server2.allocateLoad(50);
        server3.allocateLoad(50);
        double expectedTotalLoad = server1.getLoad() + server2.getLoad() + server3.getLoad();

        assertEquals(expectedTotalLoad,
                loadBalancing.getTotalLoad(servers));
    }

    @Test
    void testOptimizeInAverageLoad() {
        server1.allocateLoad(90);
        server2.allocateLoad(50);
        server3.allocateLoad(10);
        double totalLoad = server1.getLoad() + server2.getLoad() + server3.getLoad();
        double expectedMiddleLoad = totalLoad / servers.size();
        loadBalancing.optimizeInAverageLoad(totalLoad, servers);
        assertEquals(expectedMiddleLoad, server1.getLoad());
    }

    @Test
    void testOptimize() {
        dataCenterService.allocateResources(new ResourceRequest(70));
        dataCenterService.allocateResources(new ResourceRequest(70));
        dataCenterService.allocateResources(new ResourceRequest(70));

        loadBalancing.optimize(dataCenterService.getDataCenter());
    }
}

