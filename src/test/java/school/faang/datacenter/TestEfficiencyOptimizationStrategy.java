package school.faang.datacenter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEfficiencyOptimizationStrategy {

    @Test
    public void TestOptimize() throws Exception {
        List<Server> servers = List.of(
                new Server(100, 500, 20),
                new Server(200, 500, 40),
                new Server(300, 500, 60)
        );
        DataCenter dataCenter = new DataCenter(servers);


        DataCenterService dataCenterService = new DataCenterService(new EnergyEfficiencyOptimizationStrategy());

        dataCenterService.optimize(dataCenter);

        assertEquals(500, servers.get(0).getLoad(), "Loads must be equals");
        assertEquals(100, servers.get(1).getLoad(), "Loads must be equals");
        assertEquals(0, servers.get(2).getLoad(), "Loads must be equals");
    }
}
