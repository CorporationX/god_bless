package faang.school.godbless.dataCenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoadBalancingOptimizationStrategyTest {

    private DataCenterService dataCenterService;
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    @BeforeEach
    public void beforeEachSetup() {
        Server firstServer = Server.builder().load(60.0).maxLoad(100.0).energyConsumption(60.0).build();
        Server secondServer = Server.builder().load(65.0).maxLoad(70.0).energyConsumption(65.0).build();

        List<Server> servers = new ArrayList<>(Arrays.asList(firstServer, secondServer));

        dataCenter = new DataCenter();
        dataCenter.setServers(servers);

        dataCenterService = new DataCenterService(dataCenter);

        optimizationStrategy = new LoadBalancingOptimizationStrategy();
    }

    @Test
    public void testLoadBalancingOptimizationStrategy() {
        Server firstExpectedServer = Server.builder().load(62.5).maxLoad(100.0).energyConsumption(62.5).build();
        Server secondExpectedServer = Server.builder().load(62.5).maxLoad(70.0).energyConsumption(62.5).build();
        List<Server> expectedServers = new ArrayList<>(Arrays.asList(firstExpectedServer, secondExpectedServer));

        dataCenterService.optimize(List.of(optimizationStrategy));

        assertIterableEquals(expectedServers, dataCenter.getServers());
    }
}
