package operationsOptimization;

import faang.school.godbless.BJS2_19800.model.DataCenter;

import faang.school.godbless.BJS2_19800.model.Server;
import faang.school.godbless.BJS2_19800.operationsOptimization.LoadBalancingOptimizationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadBalancingOptimizationStrategyTest {
    private LoadBalancingOptimizationStrategy loadBalancingOptimizationStrategy;

    private DataCenter dataCenter;
    private Server server1;
    private Server server2;

    @BeforeEach
    public void setUp() {
        server1 = new Server(100, 50);
        server2 = new Server(150, 75);
        loadBalancingOptimizationStrategy = new LoadBalancingOptimizationStrategy();
        dataCenter = new DataCenter();
        dataCenter.getServerList().add(server1);
        dataCenter.getServerList().add(server2);
    }

    @Test
    public void testOptimizeLoadOnDataCenterServers() {
        server1.setLoad(90);
        server2.setLoad(30);
        loadBalancingOptimizationStrategy.optimize(dataCenter);
        assertEquals(60, server1.getLoad());
    }

}
