package school.faang.bjs2_79711;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs2_79711.strategy.EnergyEfficiencyOptimizationStrategy;
import school.faang.bjs2_79711.strategy.LoadBalancingOptimizationStrategy;
import school.faang.bjs2_79711.strategy.OptimizationStrategy;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DataCenterServiceTest {
    private static final int INDEX_OF_SERVER = 1;
    private static final double MIN_LOAD = 0;

    private List<Server> servers = new ArrayList<>();
    private DataCenter dataCenter = new DataCenter();
    private DataCenterService service = new DataCenterService();

    @BeforeEach
    void init() {
        servers.clear();

        servers.add(new Server(20, 100, 15.5));
        servers.add(new Server(85, 120, 40.0));
        servers.add(new Server(35, 100, 18.0));
        servers.add(new Server(70, 80, 45.5));
        servers.add(new Server(45, 100, 23.7));

        dataCenter.setServers(servers);
    }

    @Test
    void shouldAddServer() {
        Server server = new Server(0, 120, 10);
        int expected = servers.size() + 1;

        service.addServer(dataCenter, server);

        int actual = dataCenter.getServers().size();
        assertEquals(actual, expected);
    }

    @Test
    void shouldRemoveServer() {
        Server server = new Server(0, 120, 10);
        servers.add(server);
        int expected = servers.size() - 1;

        service.removeServer(dataCenter, server);
        int actual = dataCenter.getServers().size();

        assertEquals(actual, expected);
    }

    @Test
    void shouldCalculateTotalEnergyConsumption() {
        double expected = calculateTotalEnergyConsumption(servers);

        double actual = service.getTotalEnergyConsumption(dataCenter);

        assertEquals(actual, expected);
    }

    @Test
    void shouldAllocateResources() {
        ResourceRequest resourceRequest = new ResourceRequest(130);
        double expected = calculateTotalLoad(servers) + resourceRequest.load();

        service.allocateResources(dataCenter, resourceRequest);
        double actual = calculateTotalLoad(dataCenter.getServers());

        assertEquals(actual, expected);
    }

    @Test
    void shouldNotAllocateResources() {
        ResourceRequest resourceRequest = new ResourceRequest(1300);
        double expected = calculateTotalLoad(servers) + resourceRequest.load();

        service.allocateResources(dataCenter, resourceRequest);
        double actual = calculateTotalLoad(dataCenter.getServers());

        assertNotEquals(actual, expected);
    }

    @Test
    void shouldReleaseResources() {
        ResourceRequest resourceRequest = new ResourceRequest(130);
        double expected = calculateTotalLoad(servers) - resourceRequest.load();

        service.releaseResources(dataCenter, resourceRequest);
        double actual = calculateTotalLoad(dataCenter.getServers());

        assertEquals(actual, expected);
    }

    @Test
    void shouldNotReleaseResources() {
        ResourceRequest resourceRequest = new ResourceRequest(1300);
        double expected = calculateTotalLoad(servers) - resourceRequest.load();

        service.releaseResources(dataCenter, resourceRequest);
        double actual = calculateTotalLoad(dataCenter.getServers());

        assertNotEquals(actual, expected);
    }

    @Test
    void shouldOptimizeLoadWithLoadBalancingOptimizationStrategy() {
        OptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();

        service.optimizeLoad(dataCenter, strategy);
        List<Server> optimizedServers = dataCenter.getServers();

        for (int i = 0; i < optimizedServers.size() - 1; i++) {
            double actual = optimizedServers.get(i).getLoad();
            double expected = optimizedServers.get(i + 1).getLoad();

            assertEquals(actual, expected);
        }
    }

    @Test
    void shouldOptimizeLoadWithEnergyEfficiencyOptimizationStrategy() {
        OptimizationStrategy strategy = new EnergyEfficiencyOptimizationStrategy();
        servers.get(INDEX_OF_SERVER).setLoad(MIN_LOAD);
        double expected = calculateTotalEnergyConsumption(servers);

        service.optimizeLoad(dataCenter, strategy);
        double actual = calculateTotalEnergyConsumption(dataCenter.getServers());

        assertNotEquals(actual, expected);
    }

    @Test
    void shouldNotOptimizeLoadWithEnergyEfficiencyOptimizationStrategy() {
        OptimizationStrategy strategy = new EnergyEfficiencyOptimizationStrategy();
        double expected = calculateTotalEnergyConsumption(servers);

        service.optimizeLoad(dataCenter, strategy);
        double actual = calculateTotalEnergyConsumption(dataCenter.getServers());

        assertEquals(actual, expected);
    }

    private double calculateTotalLoad(List<Server> servers) {
        double totalLoad = 0.0;

        for (Server server : servers) {
            totalLoad += server.getLoad();
        }

        return totalLoad;
    }

    private double calculateTotalEnergyConsumption(List<Server> servers) {
        double totalEnergyConsumption = 0.0;

        for (Server server : servers) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }

        return totalEnergyConsumption;
    }
}