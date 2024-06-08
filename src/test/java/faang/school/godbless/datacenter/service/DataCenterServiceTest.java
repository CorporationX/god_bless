package faang.school.godbless.datacenter.service;

import faang.school.godbless.intro.datacenter.model.DataCenter;
import faang.school.godbless.intro.datacenter.model.OptimizationOperation;
import faang.school.godbless.intro.datacenter.model.ResourceRequest;
import faang.school.godbless.intro.datacenter.model.Server;
import faang.school.godbless.intro.datacenter.service.DataCenterService;
import faang.school.godbless.intro.datacenter.strategy.DefaultOptimizationStrategy;
import faang.school.godbless.intro.datacenter.strategy.EnergyEfficiencyOptimizationStrategy;
import faang.school.godbless.intro.datacenter.strategy.LoadBalancingOptimizationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {

    private DataCenterService dataCenterService;

    @BeforeEach
    public void setUp() {
        List<Server> servers = new ArrayList<>(List.of(new Server(), new Server()));
        DataCenter dataCenter = new DataCenter(servers);
        dataCenterService = new DataCenterService(dataCenter, new DefaultOptimizationStrategy());
    }

    @Test
    @DisplayName("Adding a server results in increased quantity of servers")
    void testAddServerIncreasesSize() {
        dataCenterService.addServer(new Server());

        assertEquals(3, dataCenterService.getDataCenter().servers().size());
    }

    @Test
    @DisplayName("Adding a null server results in thrown exception")
    void testAddNullServerThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> dataCenterService.addServer(null));
    }

    @Test
    @DisplayName("Removing a server results in decreased quantity of servers")
    void testDeleteServerDecreasesSize() {
        Server serverToBeDeleted = new Server();
        dataCenterService.addServer(serverToBeDeleted);

        dataCenterService.deleteServer(serverToBeDeleted);

        assertEquals(2, dataCenterService.getDataCenter().servers().size());
    }

    @Test
    @DisplayName("Removing a null server results in thrown exception")
    void testDeleteNullServerThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> dataCenterService.deleteServer(null));
    }

    @Test
    @DisplayName("Should audit overall energy consumption across the whole data center")
    void getTotalEnergyConsumption() {
        double totalEnergyConsumption = dataCenterService.getTotalEnergyConsumption();

        // default energyConsumption of a server is 100.0
        assertEquals(200.0d, totalEnergyConsumption);
    }

    @Test
    @DisplayName("Allocating resources should increase a load on a server")
    void testAllocateResourcesIncrementsLoad() {
        ResourceRequest requestedLoad = new ResourceRequest(200.0d);
        List<Server> servers = dataCenterService.getDataCenter().servers();
        servers.get(0).regulateLoad(500.0d, OptimizationOperation.INCREASE);

        dataCenterService.allocateResources(requestedLoad);

        assertEquals(200.0d, servers.get(1).getLoad());
        assertEquals(140.0d, servers.get(1).getEnergyConsumption());
    }

    @Test
    @DisplayName("Allocating null resources should throw exception")
    void testAllocateResourcesWithNull() {
        assertThrows(IllegalArgumentException.class, () -> dataCenterService.allocateResources(null));
    }

    @Test
    @DisplayName("Releasing resources should decrease a load on a server")
    void testReleaseResourcesDecrementsLoad() {
        ResourceRequest requestedLoad = new ResourceRequest(200.0d);
        List<Server> servers = dataCenterService.getDataCenter().servers();
        // energy consumption becomes 200.0
        servers.get(0).regulateLoad(500.0d, OptimizationOperation.INCREASE);

        dataCenterService.releaseResources(requestedLoad);

        assertEquals(300.0d, servers.get(0).getLoad());
        assertEquals(160.0d, servers.get(0).getEnergyConsumption());
    }

    @Test
    @DisplayName("Releasing null resources should throw exception")
    void testReleaseResourcesWithNull() {
        assertThrows(IllegalArgumentException.class, () -> dataCenterService.releaseResources(null));
    }

    @Test
    @DisplayName("Default optimization strategy scales the most loaded servers vertically")
    void testOptimizeWithDefaultStrategy() {
        List<Server> servers = dataCenterService.getDataCenter().servers();
        servers.forEach(server -> server.regulateLoad(9800.0d, OptimizationOperation.INCREASE));

        dataCenterService.optimize(dataCenterService.getOptimizationStrategy());

        assertEquals(DefaultOptimizationStrategy.class, dataCenterService.getOptimizationStrategy().getClass());
        servers.forEach(server -> assertEquals(15000.0d, server.getMaxLoad()));
    }

    @Test
    @DisplayName("Load balancing optimization strategy scales the most loaded server horizontally")
    void testOptimizeWithLoadBalancingStrategy() {
        List<Server> servers = dataCenterService.getDataCenter().servers();
        servers.get(0).regulateLoad(600.0d, OptimizationOperation.INCREASE);
        servers.get(1).regulateLoad(800.0d, OptimizationOperation.INCREASE);
        dataCenterService.setOptimizationStrategy(new LoadBalancingOptimizationStrategy());

        dataCenterService.optimize(dataCenterService.getOptimizationStrategy());

        assertEquals(LoadBalancingOptimizationStrategy.class, dataCenterService.getOptimizationStrategy().getClass());
        assertEquals(3, dataCenterService.getDataCenter().servers().size());
        assertEquals(400.0d, dataCenterService.getDataCenter().servers().get(2).getLoad());
    }

    @Test
    @DisplayName("Energy consumption optimization strategy optimizes energy spent for all servers")
    void testOptimizeWithEnergyConsumptionStrategy() {
        dataCenterService.setOptimizationStrategy(new EnergyEfficiencyOptimizationStrategy());

        dataCenterService.optimize(dataCenterService.getOptimizationStrategy());

        assertEquals(EnergyEfficiencyOptimizationStrategy.class, dataCenterService.getOptimizationStrategy().getClass());
        assertEquals(90.0d, dataCenterService.getDataCenter().servers().get(0).getEnergyConsumption());
        assertEquals(90.0d, dataCenterService.getDataCenter().servers().get(1).getEnergyConsumption());
    }
}