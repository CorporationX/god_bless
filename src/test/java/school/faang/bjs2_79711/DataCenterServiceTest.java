package school.faang.bjs2_79711;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs2_79711.strategy.EnergyEfficiencyOptimizationStrategy;
import school.faang.bjs2_79711.strategy.LoadBalancingOptimizationStrategy;
import school.faang.bjs2_79711.strategy.OptimizationStrategy;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DataCenterServiceTest {
    private List<Server> servers = new ArrayList<>();
    private DataCenter dataCenter = new DataCenter(servers);
    private DataCenterService service = new DataCenterService();

    @BeforeEach
    void init() {
        servers.clear();

        servers.add(new Server(20, 100, 15.5));
        servers.add(new Server(85, 120, 40.0));
        servers.add(new Server(35, 100, 18.0));
        servers.add(new Server(70, 80, 45.5));
        servers.add(new Server(45, 100, 23.7));
    }

    @Test
    void shouldAddServer() {
        Server server = new Server(0, 120, 10);
        int expected = servers.size() + 1;

        service.addServer(dataCenter, server);

        int result = dataCenter.getServers().size();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldRemoveServer() {
        Server server = new Server(0, 120, 10);
        servers.add(server);
        int expected = servers.size() - 1;

        service.removeServer(dataCenter, server);
        int result = dataCenter.getServers().size();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldCalculateTotalEnergyConsumption() {
        double expected = calculateTotalEnergyConsumption(servers);

        double result = service.getTotalEnergyConsumption(dataCenter);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldAllocateResources() {
        ResourceRequest resourceRequest = new ResourceRequest(130);
        double expected = calculateTotalLoad(servers) + resourceRequest.load();

        service.allocateResources(dataCenter, resourceRequest);
        double result = calculateTotalLoad(dataCenter.getServers());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldNotAllocateResources() {
        ResourceRequest resourceRequest = new ResourceRequest(1300);
        double expected = calculateTotalLoad(servers) + resourceRequest.load();

        service.allocateResources(dataCenter, resourceRequest);
        double result = calculateTotalLoad(dataCenter.getServers());

        assertThat(result).isNotEqualTo(expected);
    }

    @Test
    void shouldReleaseResources() {
        ResourceRequest resourceRequest = new ResourceRequest(130);
        double expected = calculateTotalLoad(servers) - resourceRequest.load();

        service.releaseResources(dataCenter, resourceRequest);
        double result = calculateTotalLoad(dataCenter.getServers());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldNotReleaseResources() {
        ResourceRequest resourceRequest = new ResourceRequest(1300);
        double expected = calculateTotalLoad(servers) - resourceRequest.load();

        service.releaseResources(dataCenter, resourceRequest);
        double result = calculateTotalLoad(dataCenter.getServers());

        assertThat(result).isNotEqualTo(expected);
    }

    @Test
    void shouldOptimizeLoadWithLoadBalancingOptimizationStrategy() {
        OptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();

        service.optimizeLoad(dataCenter, strategy);
        List<Server> optimizedServers = dataCenter.getServers();

        for (int i = 0; i < optimizedServers.size() - 1; i++) {
            double result = optimizedServers.get(i).getLoad();
            double expected = optimizedServers.get(i + 1).getLoad();

            assertThat(result).isEqualTo(expected);
        }
    }

    @Test
    void shouldOptimizeLoadWithEnergyEfficiencyOptimizationStrategy() {
        OptimizationStrategy strategy = new EnergyEfficiencyOptimizationStrategy();
        servers.get(1).setLoad(0);
        double expected = calculateTotalEnergyConsumption(servers);

        service.optimizeLoad(dataCenter, strategy);
        double result = calculateTotalEnergyConsumption(dataCenter.getServers());

        assertThat(result).isNotEqualTo(expected);
    }

    @Test
    void shouldNotOptimizeLoadWithEnergyEfficiencyOptimizationStrategy() {
        OptimizationStrategy strategy = new EnergyEfficiencyOptimizationStrategy();
        double expected = calculateTotalEnergyConsumption(servers);

        service.optimizeLoad(dataCenter, strategy);
        double result = calculateTotalEnergyConsumption(dataCenter.getServers());

        assertThat(result).isEqualTo(expected);
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