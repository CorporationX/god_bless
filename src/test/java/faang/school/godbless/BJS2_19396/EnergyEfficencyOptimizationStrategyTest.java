package faang.school.godbless.BJS2_19396;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnergyEfficencyOptimizationStrategyTest {

    @Test
    void optimize() {
        List<Server> servers = List.of(
                new Server(100, 60, 100),
                new Server(100, 80, 100),
                new Server(100, 95, 100)
        );
        DataCenter dataCenter = new DataCenter(servers);
        List<Server> correctAnswer = List.of(
                new Server(100, 60, 100),
                new Server(100, 64, 100),
                new Server(100, 76, 100)
        );

        OptimizationStrategy optimizationStrategy = new EnergyEfficencyOptimizationStrategy();
        optimizationStrategy.optimize(dataCenter);
        List<Server> result = dataCenter.getServers();

        assertEquals(correctAnswer, result);
    }
}