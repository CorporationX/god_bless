package faang.school.godbless.optimization_data_center;

import faang.school.godbless.optimization_data_center.dto.ResourceRequest;
import faang.school.godbless.optimization_data_center.optimization.LoadBalancingOptimizationStrategy;
import faang.school.godbless.optimization_data_center.optimization.OptimizationStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {

    private DataCenterService dataCenterService;
    private OptimizationStrategy optimizationStrategy;

    @BeforeEach
    void prepare() {
        DataCenter dataCenter = new DataCenter();
        dataCenterService = new DataCenterService(dataCenter);
        optimizationStrategy = new LoadBalancingOptimizationStrategy();

        dataCenterService.addNewServerToDataServer(new Server(0, 20, 0));
        dataCenterService.addNewServerToDataServer(new Server(10, 18, 20));
        dataCenterService.addNewServerToDataServer(new Server(8, 10, 16));
    }

    @Test
    void addNewServerToDataServer() {
        dataCenterService.addNewServerToDataServer(new Server(1,2, 2));
        assertEquals(dataCenterService.findAllServers().size(), 4);
    }

    @Test
    void deleteServerFromDataCenter() {
        dataCenterService.deleteServerFromDataCenter(new Server(0, 20, 0));
        assertEquals(dataCenterService.findAllServers().size(), 2);
    }

    @Test
    void getTotalEnergyConsumption() {
        double result = dataCenterService.getTotalEnergyConsumption();
        double expectedResult = 36;
        assertEquals(result, expectedResult);
    }

    @Test
    void allocateResources_expectedTrue() {
        boolean result = dataCenterService.allocateResources(new ResourceRequest(10));
        assertTrue(result);
    }

    @Test
    void allocateResources_expectedFalse() {
        boolean result = dataCenterService.allocateResources(new ResourceRequest(100));
        assertFalse(result);
    }

    @Test
    void releaseResources_expectedTrue_1() {
        boolean result = dataCenterService.releaseResources(new ResourceRequest(18));
        assertTrue(result);
    }

    @Test
    void releaseResources_expectedTrue_2() {
        boolean result = dataCenterService.releaseResources(new ResourceRequest(180));
        assertTrue(result);
    }

    @Test
    void optimize() {
        dataCenterService.optimize(optimizationStrategy);
        dataCenterService.findAllServers().forEach(server -> assertEquals(server.getLoad(), 6));
    }

}