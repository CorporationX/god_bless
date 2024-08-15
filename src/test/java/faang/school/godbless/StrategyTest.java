package faang.school.godbless;

import faang.school.godbless.Strategy.DataCenter;
import faang.school.godbless.Strategy.DataCenterService;
import faang.school.godbless.Strategy.LoadBalancingOptimizationStrategy;
import faang.school.godbless.Strategy.ResourceRequest;
import faang.school.godbless.Strategy.Server;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StrategyTest {
    private DataCenter dataCenter;
    private DataCenterService dataCenterService;
    private Server server1;
    private Server server2;
    private Server server3;
    private Server server4;
    private Server server5;
    private LoadBalancingOptimizationStrategy loadBalancingOptimizationStrategy;
    private ResourceRequest resourceRequest;


    @BeforeEach
    public void setUp() {
        dataCenter = new DataCenter();
        dataCenterService = new DataCenterService(dataCenter);
        loadBalancingOptimizationStrategy = new LoadBalancingOptimizationStrategy();
        dataCenterService.setOptimizationStrategy(loadBalancingOptimizationStrategy);
        resourceRequest = new ResourceRequest(2500.0);
        server1 = new Server(1000.00, 120);
        server2 = new Server(2000.00, 130);
        server3 = new Server(3000.00, 170);
        server4 = new Server(4000.00, 180);
        server5 = new Server(5000.00, 200);
        dataCenter.addServer(server1);
        dataCenter.addServer(server2);
        dataCenter.addServer(server3);
        dataCenter.addServer(server4);
        dataCenter.addServer(server5);



    }

    @DisplayName("Checking for added servers")
    @Test
    public void addServers() {
        assertEquals(5, dataCenter.getServers().size());
    }

    @DisplayName("Checking server deletion")
    @Test
    public void removeServers() {
        dataCenter.removeServer(server5);
        assertEquals(4, dataCenter.getServers().size());
        assertEquals(0.0, dataCenter.getTotalLoad());
    }

    @DisplayName("Checking load with optimize")
    @Test
    public void loadWithOptimaze() {
        dataCenterService.allocateResources(resourceRequest);
        dataCenterService.allocateResources(resourceRequest);
        dataCenterService.allocateResources(resourceRequest);
        dataCenterService.startOptimization();
        dataCenterService.allocateResources(resourceRequest);
        dataCenterService.allocateResources(resourceRequest);

        assertEquals(12500.0, dataCenter.getTotalLoad());

    }

    @DisplayName("Checking load without optimize")
    @Test
    public void loadWithoutOptimaze() {
        dataCenterService.allocateResources(resourceRequest);
        dataCenterService.allocateResources(resourceRequest);
        dataCenterService.allocateResources(resourceRequest);
        dataCenterService.allocateResources(resourceRequest);
        dataCenterService.allocateResources(resourceRequest);

        assertEquals(10000.0, dataCenter.getTotalLoad());

    }
}
