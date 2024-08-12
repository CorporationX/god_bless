package faang.school.godbless.datacenter.services;

import faang.school.godbless.datacenter.models.DataCenter;
import faang.school.godbless.datacenter.models.DataCenterMiddleOptimization;
import faang.school.godbless.datacenter.models.ResourceRequest;
import faang.school.godbless.datacenter.models.Server;
import org.junit.jupiter.api.Test;

import static faang.school.godbless.datacenter.services.DataCenterService.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataCenterServiceTest {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int SEVEN = 7;
    private static final int TEN = 10;
    private static final int TWENTY = 20;
    private static final int THIRTY = 30;
    private static final int FORTY = 40;
    private static final int MAGIC_NUMBER = 330;

    @Test
    void addNewServerTest() {
        DataCenter dataCenter = new DataCenter();

        assertEquals(dataCenter.getServers().size(), ZERO);
        addNewServer(dataCenter);
        assertEquals(dataCenter.getServers().size(), ONE);
        addNewServer(dataCenter);
        assertEquals(dataCenter.getServers().size(), TWO);
    }

    @Test
    void addServerTest() {
        DataCenter dataCenter = new DataCenter();
        Server server = new Server(TEN);

        assertEquals(dataCenter.getServers().size(), ZERO);
        addServer(dataCenter, server);
        assertEquals(dataCenter.getServers().size(), ONE);
        addServer(dataCenter, server);
        assertEquals(dataCenter.getServers().size(), TWO);
    }

    @Test
    void deleteServerTest() {
        DataCenter dataCenter = new DataCenter();
        Server server = new Server(TEN);

        assertEquals(dataCenter.getServers().size(), ZERO);

        addServer(dataCenter, server);
        server = new Server(TWENTY);
        addServer(dataCenter, server);
        server = new Server(THIRTY);
        addServer(dataCenter, server);

        assertEquals(dataCenter.getServers().size(), THREE);

        DataCenterService.deleteServer(dataCenter, server);
        server = new Server(TEN);
        DataCenterService.deleteServer(dataCenter, server);

        assertEquals(dataCenter.getServers().size(), ONE);
    }

    @Test
    void getTotalEnergyConsumptionInDataCenterTest() {
        DataCenter dataCenter = new DataCenter();

        addNewServer(dataCenter);
        addNewServer(dataCenter);

        assertEquals(DataCenterService.getTotalEnergyConsumptionInDataCenter(dataCenter), TWENTY);

        Server server = new Server(TEN);

        addServer(dataCenter, server);

        assertEquals(DataCenterService.getTotalEnergyConsumptionInDataCenter(dataCenter), FORTY);
    }

    @Test
    void allocateResourcesInDataCenterTest() {
        DataCenter dataCenter = new DataCenter();
        ResourceRequest request = new ResourceRequest(MAGIC_NUMBER);

        assertEquals(dataCenter.getServers().size(), ZERO);
        allocateResourcesInDataCenter(request, dataCenter);
        assertEquals(dataCenter.getServers().size(), FOUR);
        allocateResourcesInDataCenter(request, dataCenter);
        assertEquals(dataCenter.getServers().size(), SEVEN);
    }

    @Test
    void releaseResourcesInDataCenterTest() {
        DataCenter dataCenter = new DataCenter();
        ResourceRequest request = new ResourceRequest(MAGIC_NUMBER);

        assertEquals(dataCenter.getServers().size(), ZERO);
        allocateResourcesInDataCenter(request, dataCenter);
        assertEquals(dataCenter.getServers().size(), FOUR);
        releaseResourcesInDataCenter(request, dataCenter);
        assertEquals(dataCenter.getServers().size(), FOUR);
        assertEquals(dataCenter.getServers().stream()
                .mapToDouble(Server::getLoad).sum(), ZERO);
    }

    @Test
    void optimizeTestNotTest() {
        DataCenterService dataCenterService = new DataCenterService();
        DataCenterMiddleOptimization dataCenterMiddleOptimization = new DataCenterMiddleOptimization();

        DataCenter dataCenter = new DataCenter();
        ResourceRequest request = new ResourceRequest(MAGIC_NUMBER);
        allocateResourcesInDataCenter(request, dataCenter);
        System.out.println(dataCenter);
        dataCenterService.optimize(dataCenterMiddleOptimization, dataCenter);
        System.out.println(dataCenter);
    }
}
