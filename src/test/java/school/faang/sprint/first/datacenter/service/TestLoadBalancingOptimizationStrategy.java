package school.faang.sprint.first.datacenter.service;

import org.junit.Test;
import school.faang.sprint.first.datacenter.model.DataCenter;
import school.faang.sprint.first.datacenter.model.Server;
import school.faang.sprint.first.datacenter.service.impl.LoadBalancingOptimizationStrategy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestLoadBalancingOptimizationStrategy {
    private final DataCenterService dataCenterService =
            new DataCenterService(new LoadBalancingOptimizationStrategy());

    @Test
    public void testOptimize() {
        List<Server> servers = List.of(
                new Server(1, 100, 500, 200),
                new Server(2, 200, 600, 400)
        );

        DataCenter dataCenter = new DataCenter();
        dataCenter.getServers().addAll(servers);

        dataCenterService.optimize(dataCenter);

        assertEquals((Double) 137.0, (Double) servers.get(0).getLoad());
        assertEquals((Double) 163.0, (Double) servers.get(1).getLoad());
    }
}
