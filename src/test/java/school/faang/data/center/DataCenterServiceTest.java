package school.faang.data.center;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {
    private DataCenterService dataCenterService;

    private Server server1;
    private Server server2;
    private Server server3;

    @BeforeEach
    public void setUp() {
        OptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();
        dataCenterService = new DataCenterService(strategy);

        server1 = new Server(0, 100, 110);
        server2 = new Server(0, 200, 220);
        server3 = new Server(0, 300, 330);

        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);
    }

    @Test
    public void Test() {

    }
}