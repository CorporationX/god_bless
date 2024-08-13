package faang.school.godbless.task.hashmap.data.center.optimization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataCenterServiceTest {
    private static final double ONE_ENERGY_POINT_IN_LOAD = 2; // ENERGY == LOAD x 2
    private static final double DEFAULT_ENERGY_CONSUMPTION = 50;
    private static final double MAX_LOAD = 100;

    private Server server1 = new Server();
    private Server server2 = new Server();
    private Server server3 = new Server();

    private DataCenterService dataCenterService;

    @BeforeEach
    void setUp() {
        dataCenterService = new DataCenterService(new DataCenter(new LinkedList<>()),
                new LoadBalancingOptimizationStrategy());
    }

    @Test
    void testAddNewServer() {
        dataCenterService.addNewServer(server1);
        assertEquals(server1.getEnergyConsumption(), dataCenterService.getTotalEnergyConsumption());
    }

    @Test
    void testRemoveServer() {
        dataCenterService.addNewServer(server1);
        assertEquals(50, dataCenterService.getTotalEnergyConsumption());
        dataCenterService.removeServer(server1);
        assertEquals(0, dataCenterService.getTotalEnergyConsumption());
    }

    @Test
    void testGetTotalEnergyConsumption() {
        dataCenterService.addNewServer(server1);
        dataCenterService.addNewServer(server2);
        dataCenterService.addNewServer(server3);
        double totalDefaultEnergyCons = server1.getEnergyConsumption() +
                server2.getEnergyConsumption() + server3.getEnergyConsumption();
        assertEquals(totalDefaultEnergyCons, dataCenterService.getTotalEnergyConsumption());
    }

    @Test
    void testAllocateResources() {
        var resourceRequest = new ResourceRequest(40.0);
        dataCenterService.addNewServer(server1);
        dataCenterService.allocateResources(resourceRequest);
        double expectedTotalEnergyCons = DEFAULT_ENERGY_CONSUMPTION +
                (resourceRequest.load() / ONE_ENERGY_POINT_IN_LOAD);
        assertEquals(70, dataCenterService.getTotalEnergyConsumption());
    }

    @Test
    void testReleaseResources() {
        var resourceRequest = new ResourceRequest(40.0);
        dataCenterService.addNewServer(server1);
        dataCenterService.allocateResources(resourceRequest);
        dataCenterService.releaseResources(resourceRequest);
        assertEquals(DEFAULT_ENERGY_CONSUMPTION,
                dataCenterService.getTotalEnergyConsumption());
    }

    @Test
    void testAllocateResourceWhenHaveNoServices() {
        var resourceRequest = new ResourceRequest(40.0);
        dataCenterService.allocateResources(resourceRequest);
        // Ожидается сообщение в консоль: "Превышен лимит в N попыток оптимизации"
    }
}

