package school.faang.sprint_1.task_45027;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestDataCenterService {
    List<Server> servers;
    DataCenter dataCenter;
    ResourceRequest request;
    DataCenterService balancingService;
    DataCenterService efficiencyService;

    @BeforeEach
    public void beforeEach() {
        servers = new ArrayList<>(List.of(
                new Server(50, 100, 40),
                new Server(50, 150, 60),
                new Server(50, 200, 70),
                new Server(0, 200, 30)
        ));

        dataCenter = new DataCenter();
        dataCenter.setServers(servers);

        request = new ResourceRequest();
        request.setLoad(300);

        balancingService = new DataCenterService(dataCenter, new LoadBalancingOptimizationStrategy());
        efficiencyService = new DataCenterService(dataCenter, new EnergyEfficiencyOptimizationStrategy());
    }

    @Test
    public void addServerTest() {
        Server server = new Server(0, 100, 100);
        balancingService.addServer(server);

        assertTrue(servers.contains(server));
    }

    @Test
    public void removeServerTest() {
        Server server = new Server(0, 100, 100);
        balancingService.removeServer(server);

        assertFalse(servers.contains(server));
    }

    @Test
    public void getTotalEnergyConsumptionTest() {
        double expected = 200;
        double actual = balancingService.getTotalEnergyConsumption();
        assertEquals(expected, actual);
    }

    @Test
    public void allocateResourcesBalancingTest() {
        List<Server> expectedServers = new ArrayList<>(List.of(
                new Server(100, 100, 40),
                new Server(125, 150, 60),
                new Server(125, 200, 70),
                new Server(75, 200, 30)
        ));

        ResourceRequest expectedRequest = new ResourceRequest();
        expectedRequest.setLoad(25);

        balancingService.allocateResources(request);

        List<Server> actualServers = servers;
        ResourceRequest actualRequest = request;

        assertEquals(expectedServers, actualServers);
        assertEquals(expectedRequest, actualRequest);

    }

    @Test
    public void allocateResourcesEfficiencyTest() {
        List<Server> expectedServers = new ArrayList<>(List.of(
                new Server(100, 100, 40),
                new Server(125, 150, 60),
                new Server(111.25, 200, 70),
                new Server(17.0625, 200, 30)
        ));

        ResourceRequest expectedRequest = new ResourceRequest();
        expectedRequest.setLoad(96.6875);

        efficiencyService.allocateResources(request);

        List<Server> actualServers = servers;
        ResourceRequest actualRequest = request;

        assertEquals(expectedServers, actualServers);
        assertEquals(expectedRequest, actualRequest);

    }

    @Test
    public void releaseResourcesTest() {
        balancingService.allocateResources(request);
        balancingService.releaseResources(request);

        List<Server> expectedServers = new ArrayList<>(List.of(
                new Server(50, 100, 40),
                new Server(50, 150, 60),
                new Server(50, 200, 70),
                new Server(0, 200, 30)
        ));

        ResourceRequest expectedRequest = new ResourceRequest();
        expectedRequest.setLoad(300);

        List<Server> actualServers = servers;
        ResourceRequest actualRequest = request;

        assertEquals(expectedServers, actualServers);
        assertEquals(expectedRequest, actualRequest);
    }

}
