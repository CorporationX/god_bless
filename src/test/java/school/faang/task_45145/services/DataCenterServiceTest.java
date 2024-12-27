package school.faang.task_45145.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_45145.models.DataCenter;
import school.faang.task_45145.models.ResourceRequest;
import school.faang.task_45145.models.Server;
import school.faang.task_45145.strategies.OptimizationStrategy;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("DataCenterServiceTest: Tests for Data Center Service functionality")
class DataCenterServiceTest {

    @Test
    @DisplayName("addServer: should add server to the DataCenter")
    void addServer_shouldAddServerToTheDataCenter() {
        // Arrange
        DataCenter dataCenter = new DataCenter("Test Data Center");
        DataCenterService service = new DataCenterService(dataCenter);
        Server server = new Server("Server1", 0.0, 100.0, 20.0);

        // Act
        boolean result = service.addServer(server);

        // Assert
        assertAll("Add Server",
                () -> assertTrue(result, "Server should be added successfully"),
                () -> assertTrue(dataCenter.getServers().contains(server), "Server should exist in servers list")
        );
    }

    @Test
    @DisplayName("removeServer: should remove server from the DataCenter")
    void removeServer_shouldRemoveServerFromTheDataCenter() {
        // Arrange
        DataCenter dataCenter = new DataCenter("Test Data Center");
        DataCenterService service = new DataCenterService(dataCenter);
        Server server = new Server("Server1", 0.0, 100.0, 20.0);
        dataCenter.getServers().add(server);

        // Act
        boolean result = service.removeServer(server);

        // Assert
        assertAll("Remove Server",
                () -> assertTrue(result, "Server should be removed successfully"),
                () -> assertFalse(dataCenter.getServers().contains(server),
                        "Server should no longer exist in servers list")
        );

    }

    @Test
    @DisplayName("getTotalEnergyConsumption: should calculate total energy consumption")
    void getTotalEnergyConsumption_shouldCalculateTotalEnergyConsumption() {
        // Arrange
        DataCenter dataCenter = new DataCenter("Test Data Center");
        DataCenterService service = new DataCenterService(dataCenter);
        Server server1 = new Server("Server1", 50.0, 100.0, 20.0);
        Server server2 = new Server("Server2", 30.0, 100.0, 30.0);
        dataCenter.getServers().add(server1);
        dataCenter.getServers().add(server2);

        // Act
        double totalEnergyConsumption = service.getTotalEnergyConsumption();

        // Assert
        assertEquals(50.0, totalEnergyConsumption, "Total energy consumption should match the sum of all servers");
    }

    @Test
    @DisplayName("allocateResources: should allocate resources across servers")
    void allocateResources_shouldAllocateResourcesAcrossServers() {
        // Arrange
        DataCenter dataCenter = new DataCenter("Test Data Center");
        DataCenterService service = new DataCenterService(dataCenter);
        Server server1 = new Server("Server1", 0.0, 100.0, 20.0);
        Server server2 = new Server("Server2", 50.0, 100.0, 30.0);
        dataCenter.getServers().add(server1);
        dataCenter.getServers().add(server2);

        ResourceRequest request = new ResourceRequest(60.0);

        // Act
        boolean result = service.allocateResources(request);

        // Assert
        assertAll("Allocate Resources",
                () -> assertTrue(result, "Resources should be allocated successfully"),
                () -> assertEquals(60.0, server1.getLoad(), "Server1 should have allocated load"),
                () -> assertEquals(50.0, server2.getLoad(), "Server2 should have allocated load")
        );
    }

    @Test
    @DisplayName("releaseResources: should release resources from servers")
    void releaseResources_shouldReleaseResourcesFromServers() {
        // Arrange
        DataCenter dataCenter = new DataCenter("Test Data Center");
        DataCenterService service = new DataCenterService(dataCenter);
        Server server1 = new Server("Server1", 60.0, 100.0, 20.0);
        Server server2 = new Server("Server2", 50.0, 100.0, 30.0);
        dataCenter.getServers().add(server1);
        dataCenter.getServers().add(server2);

        ResourceRequest request = new ResourceRequest(80.0);

        // Act
        boolean result = service.releaseResources(request);

        // Assert
        assertAll("Release Resources",
                () -> assertTrue(result, "Resources should be released successfully"),
                () -> assertEquals(0.0, server1.getLoad(), "Server1 should have released all resources"),
                () -> assertEquals(30.0, server2.getLoad(), "Server2 should have released some resources")
        );
    }

    @Test
    @DisplayName("optimize: should perform optimization using the strategy")
    void optimize_shouldUseStrategyForOptimization() {
        // Arrange
        DataCenter dataCenter = new DataCenter("Test Data Center");
        DataCenterService service = new DataCenterService(dataCenter);
        OptimizationStrategy strategy = dataCenter1 -> dataCenter1.getServers().clear();
        service.setOptimizationStrategy(strategy);
        Server server = new Server("Server1", 50.0, 100.0, 20.0);
        dataCenter.getServers().add(server);

        // Act
        service.optimize();

        // Assert
        assertTrue(dataCenter.getServers().isEmpty(), "All servers should have been cleared by the strategy");
    }
}