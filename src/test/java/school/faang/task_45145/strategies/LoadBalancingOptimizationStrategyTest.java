package school.faang.task_45145.strategies;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_45145.models.DataCenter;
import school.faang.task_45145.models.Server;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Load Balancing Optimization Strategy Tests")
class LoadBalancingOptimizationStrategyTest {

    @Test
    @DisplayName("optimize: should evenly distribute load across all servers")
    void optimize_shouldEvenlyDistributeLoadAcrossAllServers() {
        // Arrange
        Set<Server> servers = new HashSet<>();
        servers.add(new Server("Server1", 50, 200, 500));
        servers.add(new Server("Server2", 100, 300, 600));
        DataCenter dataCenter = new DataCenter("TestDataCenter");
        dataCenter.getServers().addAll(servers);
        final LoadBalancingOptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();

        // Act
        strategy.optimize(dataCenter);

        // Assert
        double expectedLoad = 75;
        for (Server server : servers) {
            assertEquals(expectedLoad, server.getLoad(), "Each server's load should be updated to the average load.");
        }
    }

    @Test
    @DisplayName("optimize: should handle data center with one server")
    void optimize_shouldHandleDataCenterWithOneServer() {
        // Arrange
        LoadBalancingOptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();
        Set<Server> servers = new HashSet<>();
        servers.add(new Server("Server1", 80, 1000, 500));
        DataCenter dataCenter = new DataCenter("SingleServerDataCenter");
        dataCenter.getServers().addAll(servers);

        // Act
        strategy.optimize(dataCenter);

        // Assert
        assertEquals(80, servers.iterator().next().getLoad(),
                "The server's load should remain unchanged if it's the only server.");
    }

    @Test
    @DisplayName("optimize: should handle data center with no servers")
    void optimize_shouldHandleDataCenterWithNoServers() {
        // Arrange
        LoadBalancingOptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();
        DataCenter dataCenter = new DataCenter("EmptyDataCenter");

        // Act & Assert
        assertDoesNotThrow(() -> strategy.optimize(dataCenter),
                "Optimizing an empty data center should not throw an exception.");
    }
}