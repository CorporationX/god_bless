package bjs2_33282_dataCenter_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs2_33282_dataCenter.DataCenter;
import school.faang.bjs2_33282_dataCenter.DataCenterService;
import school.faang.bjs2_33282_dataCenter.ResourceRequest;
import school.faang.bjs2_33282_dataCenter.Server;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataCenterServiceTest {
    private DataCenterService dataCenterService;

    @BeforeEach
    public void setUp() {
        dataCenterService = new DataCenterService();
    }

    @Test
    public void testInitiateDataCenter() {
        DataCenter dataCenter = new DataCenter();

        List<ResourceRequest> requestList = new ArrayList<>(List.of(
                new ResourceRequest(25, true),
                new ResourceRequest(100, true),
                new ResourceRequest(40, false),
                new ResourceRequest(150, true)
        ));

        dataCenterService.initiateDataCenter(dataCenter, requestList);

        assertEquals(3, dataCenter.getServers().size());
        assertEquals(100, dataCenter.getServers().get(0).getLoad());
        assertEquals(35, dataCenter.getServers().get(2).getLoad());
    }

    @Test
    public void testLoadBalancingOptimizationStrategy() {
        DataCenter dataCenter = new DataCenter();

        Server server1 = new Server();
        server1.setLoad(100);
        Server server2 = new Server();
        server2.setLoad(100);
        Server server3 = new Server();
        server3.setLoad(35);

        dataCenter.getServers().addAll(List.of(server1, server2, server3));

        dataCenterService.loadBalancingOptimizationStrategy(dataCenter, 45);

        assertEquals(6, dataCenter.getServers().size());
        assertEquals(45, dataCenter.getServers().get(0).getLoad());
        assertEquals(10, dataCenter.getServers().get(5).getLoad());
    }

}
