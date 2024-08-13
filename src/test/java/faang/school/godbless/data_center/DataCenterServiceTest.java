package faang.school.godbless.data_center;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {
    DataCenterService dcService;

    @Test
    void testAllocateResources() {
        dcService = new DataCenterService();
        dcService.addServer();
        dcService.addServer();
        dcService.addServer();
        dcService.allocateResources(new ResourceRequest(60));
        assertEquals(20, dcService.getDc().getServers().get(0).getLoad());
        assertEquals(20, dcService.getDc().getServers().get(1).getLoad());
        assertEquals(20, dcService.getDc().getServers().get(2).getLoad());
    }

    @Test
    void testDeleteServer() {
        dcService = new DataCenterService();
        dcService.addServer();
        dcService.addServer();
        dcService.addServer();
        dcService.allocateResources(new ResourceRequest(60));
        dcService.deleteServer();
        assertEquals(30, dcService.getDc().getServers().get(0).getLoad());
        assertEquals(30, dcService.getDc().getServers().get(1).getLoad());
    }

    @Test
    void testReleaseResources() {
        dcService = new DataCenterService();
        dcService.addServer();
        dcService.addServer();
        dcService.addServer();
        dcService.allocateResources(new ResourceRequest(60));
        dcService.releaseResources(new ResourceRequest(30));
        assertEquals(10, dcService.getDc().getServers().get(0).getLoad());
        assertEquals(10, dcService.getDc().getServers().get(1).getLoad());
        assertEquals(10, dcService.getDc().getServers().get(2).getLoad());
    }

    @Test
    void optimize() {
        dcService = new DataCenterService();
        DataCenter dc = new DataCenter();
        dc.setServers(Arrays.asList(new Server(10, 100, 200), new Server(20, 100, 200), new Server(30, 100, 200)));
        dc.setCurrentLoadSum(60);
        dc.setMaxLoadSum(300);
        dcService.optimize(dc);
        assertEquals(20, dc.getServers().get(0).getLoad());
        assertEquals(20, dc.getServers().get(1).getLoad());
        assertEquals(20, dc.getServers().get(2).getLoad());
    }
}