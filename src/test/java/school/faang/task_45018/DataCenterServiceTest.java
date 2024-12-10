package school.faang.task_45018;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
        dataCenterService.removeServer(server, dataCenter);

        assertEquals(6, dataCenterService.getTotalEnergyConsumption());
    }

    @Test
    void shouldAllocateResources() {
        boolean allocatedResources = dataCenterService.allocateResources(new ResourceRequest(7), dataCenter);

        assertTrue(allocatedResources);
    }

    @Test
    void shouldNotAllocate() {
        boolean allocatedResources = dataCenterService.allocateResources(new ResourceRequest(20), dataCenter);

        assertFalse(allocatedResources);
    }

    @Test
    void shouldRelease() {
        boolean releasedResources = dataCenterService.releaseResources(new ResourceRequest(1), dataCenter);

        assertTrue(releasedResources);
    }

    @Test
    void shouldNotRelease() {
        boolean releasedResources = dataCenterService.releaseResources(new ResourceRequest(20), dataCenter);

        assertFalse(releasedResources);
    }
}