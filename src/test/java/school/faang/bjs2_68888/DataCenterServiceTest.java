package school.faang.bjs2_68888;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataCenterServiceTest {
    private DataCenter dataCenter;

    @BeforeEach
    void setUp() {
        dataCenter = new DataCenter();
        dataCenter.addServer(dataCenter, new Server(100, 1000, 3));
        dataCenter.addServer(dataCenter, new Server(200, 800, 1));
        dataCenter.addServer(dataCenter, new Server(1900, 2000, 9));
        dataCenter.addServer(dataCenter, new Server(10, 10, 1));
    }

    // positive scenarios
    @Test
    void testAddServer() {
        // arrange
        int expectedResult = 5;
        Server server = new Server(10, 10, 10);
        // act
        dataCenter.addServer(dataCenter, server);
        int result = dataCenter.getServers().size();
        // assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testRemoveServer() {
        // arrange
        int expectedResult = 3;
        Server server = new Server(10, 10, 1);
        // act
        dataCenter.removeServer(dataCenter, server);
        int result = dataCenter.getServers().size();
        // assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testGetTotalEnergyConsumption() {
        // arrange
        double expectedResult = 14;
        // act
        double result = DataCenterService.getTotalEnergyConsumption(dataCenter);
        // assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testAllocateResources_fullAllocation() {
        // arrange
        boolean expectedResult = true;
        ResourceRequest resourceRequest = new ResourceRequest(10);
        // act
        boolean result = DataCenterService.allocateResources(dataCenter, resourceRequest);
        // assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testAllocateResources_partialAllocation() {
        // arrange
        boolean expectedResult = false;
        ResourceRequest resourceRequest = new ResourceRequest(10_000);
        // act
        boolean result = DataCenterService.allocateResources(dataCenter, resourceRequest);
        // assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testReleaseResources_partialRelease() {
        // arrange
        double expectedResult = 2_200;
        double result = 0;
        ResourceRequest resourceRequest = new ResourceRequest(10);
        // act
        DataCenterService.releaseResources(dataCenter, resourceRequest);
        for (Server server : dataCenter.getServers()) {
            result += server.getLoad();
        }
        // assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testReleaseResources_fullRelease() {
        // arrange
        double expectedResult = 0;
        double result = 0;
        ResourceRequest resourceRequest = new ResourceRequest(2_210);
        // act
        DataCenterService.releaseResources(dataCenter, resourceRequest);
        for (Server server : dataCenter.getServers()) {
            result += server.getLoad();
        }
        // assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testOptimizeLoad_loadBalancingStrategy() {
        // arrange
        double resultBeforeOptimization = 0;
        double resultAfterOptimization = 0;
        // act
        for (Server server : dataCenter.getServers()) {
            resultBeforeOptimization += server.getLoad();
        }
        DataCenterService.optimizeLoad(new LoadBalancingOptimizationStrategy(), dataCenter);
        for (Server server : dataCenter.getServers()) {
            resultAfterOptimization += server.getLoad();
        }
        // assert
        Assertions.assertEquals(resultAfterOptimization, resultBeforeOptimization);
    }

    @Test
    void testOptimizeLoad_energyEfficiencyStrategy() {
        // arrange
        dataCenter.addServer(dataCenter, new Server(0, 10, 1));
        double energyConsumptionAfterOptimization = 0;
        double expectedResult = 14;
        // act
        DataCenterService.optimizeLoad(new EnergyEfficiencyOptimizationStrategy(), dataCenter);
        energyConsumptionAfterOptimization = DataCenterService.getTotalEnergyConsumption(dataCenter);
        // assert
        Assertions.assertEquals(expectedResult, energyConsumptionAfterOptimization);
    }

}
