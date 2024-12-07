package school.faang.task_45026.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.task_45026.entity.Server;
import school.faang.task_45026.repository.DataCenter;

import static org.junit.jupiter.api.Assertions.*;

class LoadBalancingOptimizationStrategyTest {
    OptimizationStrategy optimizationStrategy;
    DataCenter dataCenter;

    @BeforeEach
    void setUp() {
        optimizationStrategy = new LoadBalancingOptimizationStrategy();
        dataCenter = new DataCenter();
    }

    @Test
    void optimize_NothingToOptimize() {
        Server server1 = new Server(1000);
        server1.setLoad(1000);
        dataCenter.addServer(server1);

        Server server2 = new Server(2000);
        server2.setLoad(2000);
        dataCenter.addServer(server2);

        Server server3 = new Server(3000);
        server3.setLoad(3000);
        dataCenter.addServer(server3);
        double expectedLoadOnFirstServer = 1000;

        optimizationStrategy.optimize(dataCenter);

        assertEquals(expectedLoadOnFirstServer, dataCenter.getServers().get(0).getLoad());
    }

    @Test
    void optimize() {
        Server server1 = new Server(1000);
        server1.setLoad(0);
        dataCenter.addServer(server1);

        Server server2 = new Server(2000);
        server2.setLoad(2000);
        dataCenter.addServer(server2);

        Server server3 = new Server(3000);
        server3.setLoad(3000);
        dataCenter.addServer(server3);
        double expectedLoadOnFirstServer = 1000.0 * 5000 / 6000;

        optimizationStrategy.optimize(dataCenter);

        assertEquals(expectedLoadOnFirstServer, dataCenter.getServers().get(0).getLoad());
    }

    @Test
    void optimize_NullDataCenter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> optimizationStrategy.optimize(null));
        assertEquals("Data center is null", exception.getMessage());
    }
}