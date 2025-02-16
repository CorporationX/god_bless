package school.faang.sprint.first.datacenter.service;


import org.junit.Assert;
import org.junit.Test;
import school.faang.sprint.first.datacenter.model.DataCenter;
import school.faang.sprint.first.datacenter.model.ResourceRequest;
import school.faang.sprint.first.datacenter.model.Server;
import school.faang.sprint.first.datacenter.service.impl.EnergyEfficiencyOptimizationStrategy;

public class TestDataCenterService {
    private final DataCenter dataCenter = new DataCenter();
    private final DataCenterService dataCenterService =
            new DataCenterService(new EnergyEfficiencyOptimizationStrategy());

    @Test
    public void testAddServerToDataCenter() {
        Server normalServer = new Server(1, 123, 1234, 100);
        Server brokenServer = new Server(1, -1, 1234, 100);

        Assert.assertTrue(dataCenterService.addServer(dataCenter, normalServer));
        Assert.assertFalse(dataCenterService.addServer(dataCenter, brokenServer));
    }

    @Test
    public void testRemoveServerFromDataCenter() {
        Server normalServer = new Server(1, 123, 1234, 100);
        Server brokenServer = new Server(1, -1, 1234, 100);

        dataCenterService.addServer(dataCenter, normalServer);

        Assert.assertFalse(dataCenterService.removeServer(dataCenter, brokenServer));
        Assert.assertTrue(dataCenterService.removeServer(dataCenter, normalServer));
    }

    @Test
    public void testGetTotalEnergyConsumption() {
        double exceptedTotalEnergyConsumption = 199;
        Server server1 = new Server(1, 123, 1234, 100);
        Server server2 = new Server(2, 321, 4321, 99);

        dataCenterService.addServer(dataCenter, server1);
        dataCenterService.addServer(dataCenter, server2);

        Assert.assertEquals(
                (Double) exceptedTotalEnergyConsumption,
                (Double) dataCenterService.getTotalEnergyConsumption(dataCenter));
    }

    @Test
    public void testAllocateResources() {
        Server server1 = new Server(1, 123, 1234, 100);
        Server server2 = new Server(2, 321, 4321, 99);

        dataCenterService.addServer(dataCenter, server1);
        dataCenterService.addServer(dataCenter, server2);

        Assert.assertThrows(IllegalArgumentException.class,
                () -> dataCenterService.allocateResources(dataCenter, new ResourceRequest(-100)));

        Assert.assertTrue(dataCenterService.allocateResources(dataCenter, new ResourceRequest(500)));
        Assert.assertFalse(dataCenterService.allocateResources(dataCenter, new ResourceRequest(9999)));
    }
}
