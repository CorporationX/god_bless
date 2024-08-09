package faang.school.godbless.BJS2_19396;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoadBalancingOptimizationStrategyTest {

    @Test
    void optimize() {
        List<Server> servers = new ArrayList<>(List.of(
                new Server(540, 100, 100),
                new Server(250, 100, 100),
                new Server(700, 100, 100)
        ));
        DataCenter dataCenter = new DataCenter(servers);
        List<Server> correctAnswer = List.of(
                new Server(270, 50, 50),
                new Server(250, 100, 100),
                new Server(350, 50, 50),
                new Server(270, 50, 50),
                new Server(350, 50, 50)
        );

        OptimizationStrategy optimizationStrategy = new LoadBalancingOptimizationStrategy();
        DataCenterService.optimization(dataCenter, optimizationStrategy);
        List<Server> result = dataCenter.getServers();

        assertEquals(correctAnswer, result);
    }
}