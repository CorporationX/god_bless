package faang.school.godbless.datacenter.service;

import faang.school.godbless.datacenter.model.DataCenter;
import faang.school.godbless.datacenter.model.OptimizationOperation;
import faang.school.godbless.datacenter.model.ResourceRequest;
import faang.school.godbless.datacenter.model.Server;
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
        dataCenterService = new DataCenterService(dataCenter);
    }

    @Test
    @DisplayName("Adding a server results in increased quantity of servers")
    void testAddServerIncreasesSize() {
        dataCenterService.addServer(new Server());

        assertEquals(3, dataCenterService.dataCenter().servers().size());
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

        assertEquals(2, dataCenterService.dataCenter().servers().size());
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
        List<Server> servers = dataCenterService.dataCenter().servers();
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
        List<Server> servers = dataCenterService.dataCenter().servers();
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
}