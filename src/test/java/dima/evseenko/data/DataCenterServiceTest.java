package dima.evseenko.data;

import dima.evseenko.data.strategy.OptimizationStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DataCenterServiceTest {

    @Test
    void addServer() {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(new Server(45, 100, 200));

        assertEquals(new Server(45, 100, 200), dataCenterService.getServers().get(0));
    }

    @Test
    void addServers() {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServers(getServers());

        assertEquals(new Server(45, 100, 200), dataCenterService.getServers().get(0));
        assertEquals(new Server(200, 250, 400), dataCenterService.getServers().get(1));
        assertEquals(new Server(266, 266, 300), dataCenterService.getServers().get(2));
    }

    @Test
    void deleteServer() {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServers(getServers());
        dataCenterService.deleteServer(new Server(45, 100, 200));

        assertFalse(dataCenterService.getServers().contains(new Server(45, 100, 200)));
    }

    @Test
    void allocateResources() {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServers(getServers());
        dataCenterService.allocateResources(new ResourceRequest(10));

        assertEquals(new Server(55, 100, 200), dataCenterService.getServers().get(0));
    }

    @Test
    void allocateResourcesFail() {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServers(getServers());
        dataCenterService.allocateResources(new ResourceRequest(1000));

        assertEquals(new Server(45, 100, 200), dataCenterService.getServers().get(0));
    }

    @Test
    void releaseResources() {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServers(getServers());
        dataCenterService.releaseResources(new ResourceRequest(10));

        assertEquals(new Server(35, 100, 200), dataCenterService.getServers().get(0));
    }

    @Test
    void releaseResourcesFail() {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServers(getServers());
        dataCenterService.releaseResources(new ResourceRequest(1000));

        assertEquals(new Server(45, 100, 200), dataCenterService.getServers().get(0));
    }

    @Test
    void optimizeLoadBalancing() {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addOptimizationStrategy(OptimizationStrategy.Strategy.LOAD_BALANCING);
        dataCenterService.addServers(getServers());
        dataCenterService.optimize();

        assertEquals(new Server(75.12234910277324, 100, 333.87710712343664), dataCenterService.getServers().get(0));
    }

    @Test
    void optimizeEnergyEfficiency() {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addOptimizationStrategy(OptimizationStrategy.Strategy.ENERGY_EFFICIENCY);
        dataCenterService.addServers(getServers());
        dataCenterService.optimize();

        assertEquals(new Server(61.875, 100, 275.0), dataCenterService.getServers().get(0));
    }

    private List<Server> getServers() {
        return List.of(
                new Server(45, 100, 200),
                new Server(200, 250, 400),
                new Server(266, 266, 300),
                new Server(90, 90, 100),
                new Server(200, 400, 400),
                new Server(120, 120, 250)
        );
    }
}