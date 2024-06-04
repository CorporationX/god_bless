package faang.school.godbless.datacenter.service;

import faang.school.godbless.datacenter.model.DataCenter;
import faang.school.godbless.datacenter.model.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {

    private DataCenterService dataCenterService;

    @BeforeEach
    public void setUp() {
        List<Server> servers = List.of(new Server(), new Server());
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
    void deleteServer() {
        Server serverToBeDeleted = new Server();
        dataCenterService.addServer(serverToBeDeleted);

        dataCenterService.deleteServer(serverToBeDeleted);

        assertEquals(2, dataCenterService.getDataCenter().getServers().size());
    }

    @Test
    void getTotalEnergyConsumption() {
    }

    @Test
    void allocateResources() {
    }

    @Test
    void releaseResources() {
    }
}