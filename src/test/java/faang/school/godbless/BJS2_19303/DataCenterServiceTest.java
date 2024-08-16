package faang.school.godbless.BJS2_19303;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataCenterServiceTest {
    private DataCenterService dataCenterService;

    @BeforeEach
    void setUp() {
        List<Server> servers = new ArrayList<>();
        servers.add(new Server(20, 50, 100));
        servers.add(new Server(200, 300, 200));
        servers.add(new Server(100, 120, 100));
        dataCenterService = new DataCenterService(new DataCenter(servers),
                new LoadBalancingOptimizationStrategy());
        dataCenterService.startOptimization();
    }

    @Test
    void testAddServer() {
        Server server = new Server(50, 150, 100);
        dataCenterService.addServer(server);
        assertTrue(dataCenterService.getDataCenter().getServers().contains(server));

    }

    @Test
    void testRemoveServer() {
        Server server = new Server(50, 150, 100);
        dataCenterService.removeServer(server);
        assertFalse(dataCenterService.getDataCenter().getServers().contains(server));
    }

    @Test
    void testGetTotalEnergyConsumption() {
        double energyConsumption = dataCenterService.getTotalEnergyConsumption();
        assertEquals(400, energyConsumption);
    }

    @Test
    void testAllocateResources() {
        dataCenterService.allocateResources(new ResourceRequest(100));
        double totalLoad = dataCenterService.getDataCenter().getServers().stream().mapToDouble(Server::getLoad).sum();
        assertEquals(420, totalLoad);
    }

    @Test
    void testReleaseResources() {
        dataCenterService.releaseResources(new ResourceRequest(100));
        double totalLoad = dataCenterService.getDataCenter().getServers().stream().mapToDouble(Server::getLoad).sum();
        assertEquals(220, totalLoad);
    }

    @Test
    void testRequestTooBigLoad(){
        assertThrows(IllegalArgumentException.class, () -> dataCenterService.allocateResources(new ResourceRequest(1000)));
    }
}
