package faang.school.godbless.DataCenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {
    DataCenterService dataCenterService;

    @BeforeEach
    public void setUp() {
        dataCenterService = new DataCenterService();
    }

    @Test
    public void testServerAdd() {
        dataCenterService.addServerToDataCenter(new Server(60));

        assertEquals(60, dataCenterService.getMaximumLoad());
    }

    @Test
    public void testAllocateResources() {
        dataCenterService.addServerToDataCenter(new Server(60));
        dataCenterService.addServerToDataCenter(new Server(60));
        dataCenterService.allocateResources(new ResourceRequest(30));

        assertEquals(30, dataCenterService.getTotalLoad());

        dataCenterService.allocateResources(new ResourceRequest(40));

        assertEquals(70, dataCenterService.getTotalLoad());

        assertEquals(60, dataCenterService.getDataCenter().getSERVERS().get(0).getLoad());
        assertEquals(10, dataCenterService.getDataCenter().getSERVERS().get(1).getLoad());
    }

    @Test
    public void releaseResources() {
        dataCenterService.addServerToDataCenter(new Server(60));
        dataCenterService.addServerToDataCenter(new Server(60));
        dataCenterService.allocateResources(new ResourceRequest(30));
        dataCenterService.releaseResources(new ResourceRequest(15));

        assertEquals(15, dataCenterService.getTotalLoad());

        dataCenterService.releaseResources(new ResourceRequest(50));

        assertEquals(0, dataCenterService.getTotalLoad());

        dataCenterService.allocateResources(new ResourceRequest(70));
        dataCenterService.releaseResources(new ResourceRequest(15));

        assertEquals(45, dataCenterService.getDataCenter().getSERVERS().get(0).getLoad());
        assertEquals(10, dataCenterService.getDataCenter().getSERVERS().get(1).getLoad());

        dataCenterService.releaseResources(new ResourceRequest(50));

        assertEquals(0, dataCenterService.getDataCenter().getSERVERS().get(0).getLoad());
        assertEquals(5, dataCenterService.getDataCenter().getSERVERS().get(1).getLoad());
    }

    @Test
    public void testEnergyConsumption() {
        dataCenterService.addServerToDataCenter(new Server(60));
        dataCenterService.allocateResources(new ResourceRequest(30));

        assertEquals(15, dataCenterService.getTotalEnergyConsumption());

        dataCenterService.allocateResources(new ResourceRequest(10));

        assertEquals(20, dataCenterService.getTotalEnergyConsumption());

        dataCenterService.releaseResources(new ResourceRequest(10));

        assertEquals(15, dataCenterService.getTotalEnergyConsumption());
    }

    @Test
    public void testOptimization() {
        dataCenterService.addServerToDataCenter(new Server(60));
        dataCenterService.addServerToDataCenter(new Server(150));
        dataCenterService.allocateResources(new ResourceRequest(100));

        dataCenterService.optimize();

        assertEquals(50, dataCenterService.getDataCenter().getSERVERS().get(0).getLoad());
        assertEquals(50, dataCenterService.getDataCenter().getSERVERS().get(1).getLoad());

        dataCenterService.allocateResources(new ResourceRequest(30));

        assertEquals(60, dataCenterService.getDataCenter().getSERVERS().get(0).getLoad());
        assertEquals(70, dataCenterService.getDataCenter().getSERVERS().get(1).getLoad());
    }
}