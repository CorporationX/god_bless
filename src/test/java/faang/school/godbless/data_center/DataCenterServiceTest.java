package faang.school.godbless.data_center;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DataCenterServiceTest {
    DataCenterService dataCenterService;
    DataCenter dataCenter;
    Server server1;
    Server server2;
    Server server3;
    Server server4;


    @BeforeEach
    void setUp() {
        dataCenterService = new DataCenterService();
        dataCenter = new DataCenter();

        server1 = new Server(1, 350);
        server2 = new Server(2, 450);
        server3 = new Server(3, 550);
        server4 = new Server(4, 650);

        ResourceRequest request1 = new ResourceRequest(1, 10); // 1 server
        ResourceRequest request2 = new ResourceRequest(2, 20); // 2 server
        ResourceRequest request3 = new ResourceRequest(3, 30); // 3 server
        ResourceRequest request4 = new ResourceRequest(4, 40); // 4 server
        ResourceRequest request5 = new ResourceRequest(5, 50); // 1 server
        ResourceRequest request6 = new ResourceRequest(6, 70); // 2 server
        ResourceRequest request7 = new ResourceRequest(7, 80); // 3 server

        dataCenterService.addServer(dataCenter, server1);
        dataCenterService.addServer(dataCenter, server2);
        dataCenterService.addServer(dataCenter, server3);
        dataCenterService.addServer(dataCenter, server4);


        dataCenterService.allocateResources(dataCenter, request1);
        dataCenterService.allocateResources(dataCenter, request2);
        dataCenterService.allocateResources(dataCenter, request3);
        dataCenterService.allocateResources(dataCenter, request4);
        dataCenterService.allocateResources(dataCenter, request5);
        dataCenterService.allocateResources(dataCenter, request6);
        dataCenterService.allocateResources(dataCenter, request7);
    }

    @Test
    void testDataCenterService_sortingServersByLoad() {
        assertArrayEquals(new Object[]{server4, server1, server2, server3}, dataCenter.getServers().toArray());
    }

    @Test
    void testDataCenterService_sortingServersByLoadAfterAddingAndRemovingRequests() {
        ResourceRequest resourceRequest = new ResourceRequest(5, 50);

        dataCenterService.releaseResources(dataCenter, resourceRequest);

        assertArrayEquals(new Object[]{server1, server4, server2, server3}, dataCenter.getServers().toArray());
    }

    @Test
    void testDataCenterService_changeOptimizingStrategyToEnergyEfficient() {
        dataCenterService.changeOptimizationStrategy(dataCenter, OptimizationStrategy.ENERGY_EFFICIENCY_OPTIMIZATION_STRATEGY);

        assertArrayEquals(new Object[]{server4, server3, server2, server1}, dataCenter.getServers().toArray());
    }

    @Test
    void testDataCenterService_changeOptimizingStrategyToLoadBalancing() {
        dataCenterService.changeOptimizationStrategy(dataCenter, OptimizationStrategy.ENERGY_EFFICIENCY_OPTIMIZATION_STRATEGY);
        dataCenterService.changeOptimizationStrategy(dataCenter, OptimizationStrategy.LOAD_BALANCING_OPTIMIZATION_STRATEGY);

        for (Server server : dataCenter.getServers()) {
            System.out.println(server);
        }
        assertArrayEquals(new Object[]{server1, server2, server3, server4}, dataCenter.getServers().toArray());
    }

    @Test
    void testDataCenterService_totalEnergyConsumption() {
        assertEquals(400, dataCenterService.getTotalEnergyConsumption(dataCenter));
    }
}