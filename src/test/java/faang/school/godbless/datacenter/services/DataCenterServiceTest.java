package faang.school.godbless.datacenter.services;

import faang.school.godbless.datacenter.models.DataCenter;
import faang.school.godbless.datacenter.models.ResourceRequest;
import faang.school.godbless.datacenter.models.Server;
import org.junit.jupiter.api.Test;

import static faang.school.godbless.datacenter.services.DataCenterService.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataCenterServiceTest {

    @Test
    void addNewServerTest() {
        DataCenter dataCenter = new DataCenter();

        assertEquals(dataCenter.getServers().size(), 0);
        addNewServer(dataCenter);
        assertEquals(dataCenter.getServers().size(), 1);
        addNewServer(dataCenter);
        assertEquals(dataCenter.getServers().size(), 2);
    }

    @Test
    void addServerTest() {
        DataCenter dataCenter = new DataCenter();
        Server server = new Server(10);

        assertEquals(dataCenter.getServers().size(), 0);
        addServer(dataCenter, server);
        assertEquals(dataCenter.getServers().size(), 1);
        addServer(dataCenter, server);
        assertEquals(dataCenter.getServers().size(), 2);
    }

    @Test
    void deleteServerTest() {
        DataCenter dataCenter = new DataCenter();
        Server server = new Server(10);

        assertEquals(dataCenter.getServers().size(), 0);

        addServer(dataCenter, server);
        server = new Server(20);
        addServer(dataCenter, server);
        server = new Server(30);
        addServer(dataCenter, server);

        assertEquals(dataCenter.getServers().size(), 3);

        DataCenterService.deleteServer(dataCenter, server);
        server = new Server(10);
        DataCenterService.deleteServer(dataCenter, server);

        assertEquals(dataCenter.getServers().size(), 1);
    }

    @Test
    void getTotalEnergyConsumptionTest() {
        DataCenter dataCenter = new DataCenter();

        addNewServer(dataCenter);
        addNewServer(dataCenter);

        assertEquals(DataCenterService.getTotalEnergyConsumption(dataCenter), 20);

        Server server = new Server(10);

        addServer(dataCenter, server);

        assertEquals(DataCenterService.getTotalEnergyConsumption(dataCenter), 40);
    }

    @Test
    void allocateResourcesTest() {
        /*DataCenter dc = new DataCenter();
        ResourceRequest request = new ResourceRequest(99);

        assertEquals(dc.getServers().size(), 0);
        allocateResources(request, dc);
        assertEquals(dc.getServers().size(), 1);*/

        DataCenter dataCenter = new DataCenter();
        ResourceRequest request = new ResourceRequest(330);

        assertEquals(dataCenter.getServers().size(), 0);
        allocateResources(request, dataCenter);
        assertEquals(dataCenter.getServers().size(), 4);
        allocateResources(request, dataCenter);
        assertEquals(dataCenter.getServers().size(), 7);
    }

    @Test
    void releaseResourcesTest() {
        DataCenter dataCenter = new DataCenter();
        ResourceRequest request = new ResourceRequest(330);

        assertEquals(dataCenter.getServers().size(), 0);
        allocateResources(request, dataCenter);
        assertEquals(dataCenter.getServers().size(), 4);
        releaseResources(request, dataCenter);
        assertEquals(dataCenter.getServers().size(), 4);
        assertEquals(dataCenter.getServers().stream()
                .mapToDouble(Server::getLoad).sum(), 0);

        /*DataCenter dataCenter = new DataCenter();
        ResourceRequest request = new ResourceRequest(330);

        assertEquals(dataCenter.getServers().size(), 0);
        allocateResources(request, dataCenter);
        assertEquals(dataCenter.getServers().size(), 4);
        request = new ResourceRequest(300);
        releaseResources(request, dataCenter);
        assertEquals(dataCenter.getServers().size(), 4);
        assertEquals(dataCenter.getServers().stream()
                .mapToDouble(Server::getLoad).sum(), 30);*/

        /*DataCenter dataCenter = new DataCenter();
        ResourceRequest request = new ResourceRequest(30);
        releaseResources(request, dataCenter);*/
    }

    @Test
    void optimizeTestNotTest() {
        DataCenterService dataCenterService = new DataCenterService();

        DataCenter dataCenter = new DataCenter();
        ResourceRequest request = new ResourceRequest(330);
        allocateResources(request, dataCenter);
        System.out.println(dataCenter);
        dataCenterService.optimize(dataCenter);
        System.out.println(dataCenter);
    }
}
