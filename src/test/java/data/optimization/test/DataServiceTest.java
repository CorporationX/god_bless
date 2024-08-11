package data.optimization.test;

import data.optimization.DataCenter;
import data.optimization.DataCenterService;
import data.optimization.ResourceRequest;
import data.optimization.Server;
import data.optimization.optim.strategy.OptimizationStrategy;
import data.optimization.optim.strategy.SillyOptimizationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataServiceTest {
    private DataCenter dataCenter;

    @BeforeEach
    void setUp() {
        dataCenter = new DataCenter();
    }

    @Test
    @DisplayName("Testing add server")
    void serviceTest_addServer() {
        Server server = new Server(5, 1);

        DataCenterService.addServer(dataCenter, server);

        assertTrue(dataCenter.getServerLoadsMap().containsKey(server));
    }

    @Test
    @DisplayName("Testing add added server")
    void serviceTest_addAddedServer() {
        Server server = new Server(5, 1);

        DataCenterService.addServer(dataCenter, server);
        DataCenterService.addServer(dataCenter, server);

        assertAll(
                () -> assertTrue(dataCenter.getServerLoadsMap().containsKey(server)),
                () -> assertEquals(1, dataCenter.getServerLoadsMap().size())
        );
    }

    @Test
    @DisplayName("Testind add server with null arguments")
    void serviceTest_addServerWithNullArguments() {
        Server server = new Server(5, 1);

        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> DataCenterService.addServer(dataCenter, null)
                ),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> DataCenterService.addServer(null, server)
                )
        );
    }

    @Test
    @DisplayName("Testing remove server")
    void serviceTest_removeServer() {
        Server server = new Server(5, 1);
        DataCenterService.addServer(dataCenter, server);

        DataCenterService.removeServer(dataCenter, server);

        assertAll(
                () -> assertFalse(dataCenter.getServerLoadsMap().containsKey(server)),
                () -> assertEquals(0, dataCenter.getServerLoadsMap().size())
        );
    }

    @Test
    @DisplayName("Testing remove server not in data center")
    void serviceTest_removeServerNotInDataCenter() {
        Server server = new Server(5, 1);
        DataCenterService.addServer(dataCenter, server);

        DataCenterService.removeServer(dataCenter, new Server(8, 1));

        assertEquals(1, dataCenter.getServerLoadsMap().size());
    }

    @Test
    @DisplayName("Testing remove server with null arguments")
    void serviceTest_removeServerWithNullArguments() {
        Server server = new Server(5, 1);
        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> DataCenterService.removeServer(null, server)
                ),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> DataCenterService.releaseResource(dataCenter, null)
                )
        );
    }

    @Test
    @DisplayName("Testing getTotalEnergyConsumption method on empty data center")
    void serviceTest_getEnergyConsumptionOnEmptyDataCenter() {
        assertEquals(0, DataCenterService.getTotalEnergyConsumption(dataCenter));
    }

    @Test
    @DisplayName("Testing getTotalEnergyConsumption method consumption on data center with load")
    void serviceTest_getEnergyConsumption() {
        Server server = new Server(5, 1);
        ResourceRequest request = new ResourceRequest(4);
        DataCenterService.addServer(dataCenter, server);
        DataCenterService.allocateResource(dataCenter, request);

        assertEquals(0.8, DataCenterService.getTotalEnergyConsumption(dataCenter));
    }

    @Test
    @DisplayName("Testing getTotalEnergyConsumption method with null arguments")
    void serviceTest_getEnergyConsumptionWithNullArguments() {
        assertThrows(NullPointerException.class, () -> DataCenterService.getTotalEnergyConsumption(null));
    }

    @Test
    @DisplayName("Testing allocateResource method")
    void serviceTest_allocateResource() {
        Server server = new Server(5, 1);
        ResourceRequest request = new ResourceRequest(4);
        DataCenterService.addServer(dataCenter, server);

        DataCenterService.allocateResource(dataCenter, request);

        assertAll(
                () -> assertTrue(server.getRequestsLoad().containsKey(request)),
                () -> assertEquals(request.getLoad(), server.getLoad())
        );
    }

    @Test
    @DisplayName("Testing allocateResource method with too big request")
    void serviceTest_allocateResourceWithBigRequest() {
        Server server = new Server(5, 1);
        ResourceRequest request = new ResourceRequest(8);
        DataCenterService.addServer(dataCenter, server);

        DataCenterService.allocateResource(dataCenter, request);

        assertAll(
                () -> assertFalse(server.getRequestsLoad().containsKey(request)),
                () -> assertEquals(0, server.getLoad()),
                () -> assertEquals(0, DataCenterService.getTotalEnergyConsumption(dataCenter))
        );
    }

    @Test
    @DisplayName("Testing allocateResource method with null arguments")
    void serviceTest_allocateResourceWithNullArguments() {
        ResourceRequest request = new ResourceRequest(4);
        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> DataCenterService.allocateResource(null, request)
                ),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> DataCenterService.allocateResource(dataCenter, null)
                )
        );
    }

    @Test
    @DisplayName("Testing releaseResource method")
    void serviceTest_releaseResource() {
        Server server = new Server(5, 1);
        ResourceRequest request = new ResourceRequest(4);
        DataCenterService.addServer(dataCenter, server);
        DataCenterService.allocateResource(dataCenter, request);

        DataCenterService.releaseResource(dataCenter, request);

        assertAll(
                () -> assertFalse(server.getRequestsLoad().containsKey(request)),
                () -> assertEquals(0, server.getRequestsLoad().size()),
                () -> assertEquals(0, server.getLoad())
        );
    }

    @Test
    @DisplayName("Testing releaseResource method with not allocated request")
    void serviceTest_releaseResourceWithRequestNotAllocated() {
        Server server = new Server(5, 1);
        ResourceRequest request = new ResourceRequest(4);
        DataCenterService.addServer(dataCenter, server);
        DataCenterService.allocateResource(dataCenter, request);

        DataCenterService.releaseResource(dataCenter, new ResourceRequest(8));

        assertAll(
                () -> assertTrue(server.getRequestsLoad().containsKey(request)),
                () -> assertEquals(1, server.getRequestsLoad().size()),
                () -> assertEquals(request.getLoad(), server.getLoad())
        );
    }

    @Test
    @DisplayName("Testing releaseResource method with null arguments")
    void serviceTest_releaseResourceWithNullArguments() {
        ResourceRequest request = new ResourceRequest(4);

        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> DataCenterService.releaseResource(null, request)
                ),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> DataCenterService.releaseResource(dataCenter, null)
                )
        );
    }

    @Test
    @DisplayName("Testing setOptimizationStrategy method")
    void serviceTest_setStrategy() {
        OptimizationStrategy strategy = new SillyOptimizationStrategy();

        DataCenterService.setOptimizationStrategy(strategy);

        assertEquals(strategy, DataCenterService.getOptimizationStrategy());
    }

    @Test
    @DisplayName("Testing setOptimizationStrategy method with null arguments")
    void serviceTest_setStrategyWithNull() {
        assertThrows(NullPointerException.class, () -> DataCenterService.setOptimizationStrategy(null));
    }

    @Test
    @DisplayName("Testing optimize method")
    void serviceTest_optimize() {
        assertDoesNotThrow(() -> DataCenterService.optimize(dataCenter));
    }

    @Test
    @DisplayName("Testing optimize method with null arguments")
    void serviceTest_optimizeWithNullArguments() {
        assertThrows(NullPointerException.class, () -> DataCenterService.optimize(null));
    }
}
