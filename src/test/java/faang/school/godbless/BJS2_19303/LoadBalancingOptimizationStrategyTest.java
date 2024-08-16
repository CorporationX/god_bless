package faang.school.godbless.BJS2_19303;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoadBalancingOptimizationStrategyTest {

    private OptimizationStrategy optimizationStrategy;
    private DataCenter dataCenter;

    @BeforeEach
    void setUp() {
        optimizationStrategy = new LoadBalancingOptimizationStrategy();
        dataCenter = new DataCenter(List.of(new Server(20, 50, 50),
                new Server(200, 300, 150), new Server(100, 120, 100)));
    }

    @Test
    void testOptimize() {
        optimizationStrategy.optimize(dataCenter);
        Server server = dataCenter.getServers().get(0);
        assertEquals(34, (int) server.getLoad());

        server = dataCenter.getServers().get(1);
        assertEquals(204, (int) server.getLoad());

        server = dataCenter.getServers().get(2);
        assertEquals(81, (int) server.getLoad());
    }

    @Test
    void testEmptyList(){
        assertThrows(IllegalArgumentException.class, () -> optimizationStrategy.optimize(new DataCenter(new ArrayList<>())));
    }
}
