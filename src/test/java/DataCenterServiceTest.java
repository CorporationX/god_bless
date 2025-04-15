import optimizingdatacenter.DataCenter;
import optimizingdatacenter.DataCenterService;
import optimizingdatacenter.EnergyEfficiencyOptimizationStrategy;
import optimizingdatacenter.LoadBalancingOptimizationStrategy;
import optimizingdatacenter.OptimizationStrategy;
import optimizingdatacenter.ResourceRequest;
import optimizingdatacenter.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataCenterServiceTest {

    private DataCenter dataCenter;
    private DataCenterService service;

    @BeforeEach
    public void setUp() {
        dataCenter = new DataCenter();
        service = new DataCenterService();

        Server s1 = new Server(30, 100, 50);
        Server s2 = new Server(50, 100, 40);
        Server s3 = new Server(20, 100, 40);

        dataCenter.getServers().addAll(Arrays.asList(s1, s2, s3));
    }

    @Test
    public void testAllocateResources_Successful() {
        ResourceRequest request = new ResourceRequest();
        request.setLoad(50);

        boolean allocated = service.allocateResources(dataCenter, request);
        assertTrue(allocated, "Ресурсы должны быть успешно выделены");

        double totalLoad = dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
        assertEquals(150, totalLoad, 0.01);
    }

    @Test
    public void testAllocateResources_Fail() {
        ResourceRequest request = new ResourceRequest();
        request.setLoad(500);

        boolean allocated = service.allocateResources(dataCenter, request);
        assertFalse(allocated, "Ресурсы не должны быть выделены");
    }

    @Test
    public void testReleaseResources() {
        ResourceRequest request = new ResourceRequest();
        request.setLoad(60);

        service.releaseResources(dataCenter, request);
        double totalLoad = dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
        assertEquals(40, totalLoad, 0.01);
    }

    @Test
    public void testGetTotalEnergyConsumption() {
        double total = service.getTotalEnergyConsumption(dataCenter);
        assertEquals(130.0, total, 0.01);
    }

    @Test
    public void testOptimizeLoadBalancingStrategy() {
        OptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();
        service.optimize(dataCenter, strategy);

        double expected = dataCenter.getServers().get(0).getLoad();
        for (Server s : dataCenter.getServers()) {
            assertEquals(expected, s.getLoad(), 0.01);
        }
    }

    @Test
    public void testOptimizeEnergyEfficiencyStrategy() {
        dataCenter.getServers().get(1).setLoad(0);
        dataCenter.getServers().get(1).setEnergyConsumption(25);

        OptimizationStrategy strategy = new EnergyEfficiencyOptimizationStrategy();
        service.optimize(dataCenter, strategy);

        assertEquals(0.0, dataCenter.getServers().get(1).getEnergyConsumption(), 0.01);
    }
}
