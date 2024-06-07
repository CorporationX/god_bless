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

        assertEquals(3, dataCenterService.getDataCenter().getServers().size());
    }

    @Test
    @DisplayName("Removing a server results in decreased quantity of servers")
    void testDeleteServerDecreasesSize() {
        Server serverToBeDeleted = new Server();
        dataCenterService.addServer(serverToBeDeleted);

        dataCenterService.deleteServer(serverToBeDeleted);

        assertEquals(2, dataCenterService.getDataCenter().getServers().size());
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
        ResourceRequest requestedLoad = new ResourceRequest(250.0d);
        List<Server> servers = dataCenterService.getDataCenter().getServers();
        servers.get(0).regulateLoad(500.0d, OptimizationOperation.INCREASE);

        dataCenterService.allocateResources(requestedLoad);

        assertEquals(250.0d, servers.get(1).getLoad());
    }

    @Test
    @DisplayName("Releasing resources should decrease a load on a server")
    void testReleaseResourcesDecrementsLoad() {
        ResourceRequest requestedLoad = new ResourceRequest(250.0d);
        List<Server> servers = dataCenterService.getDataCenter().getServers();
        servers.get(0).regulateLoad(500.0d, OptimizationOperation.INCREASE);

        dataCenterService.releaseResources(requestedLoad);

        assertEquals(250.0d, servers.get(0).getLoad());
    }
}