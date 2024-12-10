package school.faang.sprint_1.task_45026.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.sprint_1.task_45026.entity.Server;
import school.faang.sprint_1.task_45026.repository.DataCenter;

import static org.junit.jupiter.api.Assertions.*;

class EnergyEfficiencyOptimizationStrategyTest {
    OptimizationStrategy optimizationStrategy;
    DataCenter dataCenter;

    @BeforeEach
    void setUp() {
        optimizationStrategy = new EnergyEfficiencyOptimizationStrategy();
        dataCenter = new DataCenter();

        Server server1 = new Server(1000);
        server1.setLoad(1000);
        server1.setEnergyConsumption(100);
        dataCenter.addServer(server1);
        
        Server server2 = new Server(2000);
        server2.setLoad(2000);
        server2.setEnergyConsumption(200);
        dataCenter.addServer(server2);
        
        Server server3 = new Server(3000);
        server3.setLoad(3000);
        server3.setEnergyConsumption(300);
        dataCenter.addServer(server3);
    }

    @Test
    void optimize_NothingToOptimize() {
        double expectedEnergyConsumption = 600;

        optimizationStrategy.optimize(dataCenter);

        double totalEnergyConsumption = dataCenter.getServers()
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();

        assertEquals(expectedEnergyConsumption, totalEnergyConsumption);
    }

    @Test
    void optimize() {
        dataCenter.getServers().get(0).setLoad(0);
        dataCenter.getServers().get(1).setLoad(0);
        double expectedEnergyConsumption = 300;

        optimizationStrategy.optimize(dataCenter);

        double totalEnergyConsumption = dataCenter.getServers()
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();

        assertEquals(expectedEnergyConsumption, totalEnergyConsumption);
    }

    @Test
    void optimize_NullDataCenter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> optimizationStrategy.optimize(null));
        assertEquals("Data center is null", exception.getMessage());
    }
}