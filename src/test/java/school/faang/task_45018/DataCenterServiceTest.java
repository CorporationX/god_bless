package school.faang.task_45018;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.faang.task_45018.DataInitializerUtils.initDataCenter;

class DataCenterServiceTest {
    private final DataCenter dataCenter = new DataCenter(initDataCenter());
    private final DataCenterService dataCenterService = new DataCenterService(dataCenter,
            new LoadBalancingOptimizationStrategy());

    @Test
    void shouldAddServer() {
        dataCenterService.addServer(new Server(1, 1, 1));

        double actualTotalEnergyConsumption = dataCenterService.getTotalEnergyConsumption();

        assertEquals(17, actualTotalEnergyConsumption);
    }

    @Test
    void shouldRemoveServer() {
        Server server = new Server(1, 5, 10);
        dataCenterService.removeServer(server);

        assertEquals(6, dataCenterService.getTotalEnergyConsumption());
    }

    @Test
    void shouldAllocateResources() {
        List<Server> servers = dataCenter.getDataCenters();

        dataCenterService.allocateResources(new ResourceRequest(7));

        assertEquals(5, servers.get(0).getLoad());
    }

    @Test
    void shouldRelease() {
        List<Server> servers = dataCenter.getDataCenters();

        dataCenterService.releaseResources(new ResourceRequest(1));

        assertEquals(0, servers.get(0).getLoad());
    }
}