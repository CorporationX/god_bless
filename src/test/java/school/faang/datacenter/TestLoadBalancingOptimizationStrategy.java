package school.faang.datacenter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoadBalancingOptimizationStrategy {

    @Test
    public void testSameLoad() throws Exception {
        List<Server> servers = List.of(
                new Server(100, 500, 20),
                new Server(200, 500, 40),
                new Server(300, 500, 60)
        );
        DataCenter dataCenter = new DataCenter(servers);


        DataCenterService dataCenterService = new DataCenterService(new LoadBalancingOptimizationStrategy());

        dataCenterService.optimize(dataCenter);

        assertThat(servers).allMatch(server -> server.getLoad() == 200, "All servers load must be equal");
    }

    @Test
    public void testNotSameLoad() throws Exception {
        List<Server> servers = List.of(
                new Server(100, 150, 20),
                new Server(200, 500, 40),
                new Server(300, 500, 60)
        );
        DataCenter dataCenter = new DataCenter(servers);


        DataCenterService dataCenterService = new DataCenterService(new LoadBalancingOptimizationStrategy());

        dataCenterService.optimize(dataCenter);

        assertEquals(150, servers.get(0).getLoad(), "Loads must be equal");
        assertEquals(225, servers.get(1).getLoad(), "Loads must be equal");
        assertEquals(225, servers.get(2).getLoad(), "Loads must be equal");
    }
}
