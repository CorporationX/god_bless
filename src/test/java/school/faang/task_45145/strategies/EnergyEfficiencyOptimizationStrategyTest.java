package school.faang.task_45145.strategies;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_45145.models.DataCenter;
import school.faang.task_45145.models.Server;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Energy Efficiency Optimization Strategy Tests")
class EnergyEfficiencyOptimizationStrategyTest {

    @Test
    @DisplayName("optimize: should set energy consumption to 0 for servers with zero load")
    void optimize_shouldSetEnergyConsumptionToZeroForServersWithZeroLoad() {
        // Arrange
        String dataCenterName = "Test Data Center";
        Server server1 = new Server("Server1", 0, 50, 300);
        Server server2 = new Server("Server2", 10, 200, 500);
        Set<Server> servers = new HashSet<>(Set.of(server1, server2));
        DataCenter dataCenter = new DataCenter(dataCenterName);
        dataCenter.getServers().addAll(servers);

        OptimizationStrategy strategy = new EnergyEfficiencyOptimizationStrategy();

        // Act
        strategy.optimize(dataCenter);

        // Assert
        assertAll("Validate server energy consumption after optimization",
                () -> assertEquals(0, server1.getEnergyConsumption(),
                        "Energy consumption for Server1 should be 0"),
                () -> assertEquals(500, server2.getEnergyConsumption(),
                        "Energy consumption for Server2 should remain unchanged")
        );
    }

    @Test
    @DisplayName("optimize: should not modify energy consumption for servers with non-zero load")
    void optimize_shouldNotModifyEnergyConsumptionForServersWithNonZeroLoad() {
        // Arrange
        String dataCenterName = "Test Data Center";
        Server server1 = new Server("Server1", 15, 100, 400);
        Server server2 = new Server("Server2", 25, 300, 600);
        Set<Server> servers = new HashSet<>(Set.of(server1, server2));
        DataCenter dataCenter = new DataCenter(dataCenterName);
        dataCenter.getServers().addAll(servers);

        OptimizationStrategy strategy = new EnergyEfficiencyOptimizationStrategy();

        // Act
        strategy.optimize(dataCenter);

        // Assert
        assertAll("Validate that energy consumption remains unchanged for servers with non-zero load",
                () -> assertEquals(400, server1.getEnergyConsumption(),
                        "Energy consumption for Server1 should remain unchanged"),
                () -> assertEquals(600, server2.getEnergyConsumption(),
                        "Energy consumption for Server2 should remain unchanged")
        );
    }

    @Test
    @DisplayName("optimize: should handle empty list of servers in the Data Center")
    void optimize_shouldHandleEmptyListOfServers() {
        // Arrange
        String dataCenterName = "Empty Data Center";
        DataCenter dataCenter = new DataCenter(dataCenterName);

        OptimizationStrategy strategy = new EnergyEfficiencyOptimizationStrategy();

        // Act
        strategy.optimize(dataCenter);

        // Assert
        assertEquals(0, dataCenter.getServers().size(),
                "No servers should exist in the Data Center");
    }
}