package school.faang.task45024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {

    private DataCenterService dataCenterService;

    @BeforeEach
    void setUp() {
        dataCenterService = new DataCenterService(new DataCenter(new ArrayList<>(
                List.of(
                        new Server(50, 100, 200),
                        new Server(100, 120, 400),
                        new Server(30, 30, 150))
        )));

    }

    @Test
    void getTotalEnergyConsumption() {
        assertEquals(750, dataCenterService.getTotalEnergyConsumption());
    }

    @Test
    void addServer() {
        Server server = new Server(200, 300, 500);
        dataCenterService.addServer(server);
        assertTrue(dataCenterService
                .getDataCenter()
                .getServers()
                .contains(server));
    }

    @Test
    void allocateResources() {
        ResourceRequest request = new ResourceRequest(70);
        dataCenterService.allocateResources(request);
        assertEquals(100, dataCenterService.getDataCenter().getServers().get(0).getLoad());
        assertEquals(120, dataCenterService.getDataCenter().getServers().get(1).getLoad());
    }

    @Test
    void removeServer() {
        Server server = new Server(50, 100, 200);
        dataCenterService.remove(server);
        assertFalse(dataCenterService.getDataCenter().getServers().contains(server));
    }

    @Test
    void releaseResources() {
        ResourceRequest request = new ResourceRequest(70);
        dataCenterService.releaseResources(request);
        assertEquals(0, dataCenterService.getDataCenter().getServers().get(0).getLoad());
    }

    @Test
    void optimize() {
        dataCenterService.optimize(dataCenterService.getDataCenter());
        assertEquals(60, dataCenterService.getDataCenter().getServers().get(0).getLoad());
        assertEquals(60, dataCenterService.getDataCenter().getServers().get(1).getLoad());
        assertEquals(60, dataCenterService.getDataCenter().getServers().get(2).getLoad());
    }
}