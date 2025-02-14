package school.faang.sprint.first.datacenter.service;

import org.junit.Test;
import school.faang.sprint.first.datacenter.model.DataCenter;
import school.faang.sprint.first.datacenter.model.Server;
import school.faang.sprint.first.datacenter.service.impl.EnergyEfficiencyOptimizationStrategy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestEnergyEfficiencyOptimizationStrategy {
    private final DataCenterService dataCenterService =
            new DataCenterService(new EnergyEfficiencyOptimizationStrategy());

    @Test
    public void testOptimize() {
        List<Server> servers = List.of(
                new Server(1, 100, 500, 200),
                new Server(2, 200, 600, 400)
        );

        DataCenter dataCenter = new DataCenter();
        dataCenter.getServers().addAll(servers);

        dataCenterService.optimize(dataCenter);

        assertEquals((Double) 300.0, (Double) servers.get(0).getLoad());
        assertEquals((Double) 0.0, (Double) servers.get(1).getLoad());

    }
}
