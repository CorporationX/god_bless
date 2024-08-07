package faang.school.godbless.BJS2_19415;

import faang.school.godbless.BJS2_19415.OptimizationStrategy.LoadBalancingOptimizationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataCenterServiceTest {
    private DataCenterService dataCenterService;

    @BeforeEach
    void setUp() {
        dataCenterService = new DataCenterService(new DataCenter());
    }

    //positive
    @Test
    @DisplayName("Add servers to dataCenter")
    void testAddServerToDataCenter() {
        //arrange
        Server serverOne = new Server(1000);
        Server serverTwo = new Server(500);
        int expected = 2;

        //act
        dataCenterService.addServer(serverOne);
        dataCenterService.addServer(serverTwo);
        dataCenterService.viewCluster();

        //assert
        assertEquals(expected, dataCenterService.getDataCenter().getServersQuantity());
    }

    @Test
    @DisplayName("Remove servers from dataCenter")
    void testRemoveServerToDataCenter() {
        //arrange
        Server serverOne = new Server(1000);
        Server serverTwo = new Server(500);
        int expected = 1;

        //act
        dataCenterService.addServer(serverOne);
        dataCenterService.addServer(serverTwo);
        dataCenterService.removeServer(serverOne);

        //assert
        assertEquals(expected, dataCenterService.getDataCenter().getServersQuantity());
    }

    @Test
    @DisplayName("Load and energy")
    void testLoadToEnergyDependence() {
        //arrange
        double allocatedLoad = 20.0;
        double maxEnergyConsumption = 1000.0;
        double expectedEnergyConsumption = 200.0;

        //act
        Server server = new Server(maxEnergyConsumption);
        server.setLoad(allocatedLoad);
        double targetEnergyConsumption = server.getEnergyConsumption();

        //assert
        assertEquals(expectedEnergyConsumption, targetEnergyConsumption);
    }

    @ParameterizedTest
    @DisplayName("Allocate Resources")
    @CsvSource({"0.0, 0.0", "100.0, 100.0", "120.0, 120.0", "200.0, 200.0"})
    void testAllocateResources(double allocatedLoad, double expectedTotalClusterLoad) {
        //arrange
        Server serverOne = new Server(1000);
        Server serverTwo = new Server(500);

        //act
        dataCenterService.addServer(serverOne);
        dataCenterService.addServer(serverTwo);
        dataCenterService.allocateResources(new ResourceRequest(allocatedLoad));
        double resultTotalClusterLoad = dataCenterService.getTotalLoad();
        dataCenterService.viewCluster();

        //assert
        assertEquals(expectedTotalClusterLoad, resultTotalClusterLoad);
    }

    @ParameterizedTest
    @DisplayName("Release Resources")
    @CsvSource({"0.0, 200.0", "100.0, 100.0", "120.0, 80.0", "200.0, 0.0"})
    void testReleaseResources(double releasedLoad, double expectedTotalClusterLoad) {
        //arrange
        double allocatedLoad = 200.0;
        Server serverOne = new Server(1000);
        Server serverTwo = new Server(500);

        //act
        dataCenterService.addServer(serverOne);
        dataCenterService.addServer(serverTwo);
        dataCenterService.allocateResources(new ResourceRequest(allocatedLoad));
        dataCenterService.viewCluster();
        dataCenterService.releaseResources(new ResourceRequest(releasedLoad));
        dataCenterService.viewCluster();
        double resultTotalClusterLoad = dataCenterService.getTotalLoad();

        //assert
        assertEquals(expectedTotalClusterLoad, resultTotalClusterLoad);
    }

    @Test
    @DisplayName("Load Balancing")
    void testClusterLoadBalancing() {
        //arrange
        double allocatedLoad = 120.0;
        double expectedServerLoad = 60.0;
        Server serverOne = new Server(1000);
        Server serverTwo = new Server(500);

        //act
        dataCenterService.addServer(serverOne);
        dataCenterService.addServer(serverTwo);
        dataCenterService.allocateResources(new ResourceRequest(allocatedLoad));
        dataCenterService.viewCluster();
        dataCenterService.optimizeCluster(new LoadBalancingOptimizationStrategy());
        dataCenterService.viewCluster();
        double actualServerOneLoad = serverOne.getLoad();
        double actualServerTwoLoad = serverTwo.getLoad();

        //assert
        assertEquals(expectedServerLoad, actualServerOneLoad);
        assertEquals(expectedServerLoad, actualServerTwoLoad);
    }

    //negative
    @Test
    @DisplayName("Negative load value")
    void testNegativeLoadValue() {
        //arrange
        double negativeLoad = -100.0;

        //act assert
        assertThrows(IllegalArgumentException.class, () -> new ResourceRequest(negativeLoad));
    }

    @Test
    @DisplayName("Wrong allocate request")
    void testWrongAllocateRequest() {
        //arrange
        double allocateLoad = 300;
        Server server = new Server(100);
        ResourceRequest request = new ResourceRequest(allocateLoad);

        //act assert
        dataCenterService.addServer(server);
        assertThrows(IllegalArgumentException.class, () -> dataCenterService.releaseResources(request));
    }

    @Test
    @DisplayName("Wrong release request")
    void testWrongReleaseRequest() {
        //arrange
        double allocateLoad = 20;
        double releaseLoad = 40;

        Server server = new Server(100);
        ResourceRequest allocateRequest = new ResourceRequest(allocateLoad);
        ResourceRequest releaseRequest = new ResourceRequest(releaseLoad);

        //act assert
        dataCenterService.addServer(server);
        dataCenterService.allocateResources(allocateRequest);
        assertThrows(IllegalArgumentException.class, () -> dataCenterService.releaseResources(releaseRequest));
    }


}
