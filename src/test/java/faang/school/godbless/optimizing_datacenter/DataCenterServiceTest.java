package faang.school.godbless.optimizing_datacenter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {
    private static DataCenterService service;

    @BeforeAll
    public static void setUp() {
        service = new DataCenterService();
        Server rac1 = new Server(15);
        Server rac2 = new Server(5);
        Server rac3 = new Server(10);

        service.addServer(rac1);
        service.addServer(rac2);
        service.addServer(rac3);
    }

    @Test
    public void testEnergyConsumption() {
//        expected 3 because exp function for energyConsumption 1 when passed 0 load
        assertEquals(3, service.getTotalEnergyConsumption());
    }

//    not sure if its ok but dont know how to implement them in separate tests without overcomplicating it
    @Test
    public void testAddAndRelease() {
        ResourceRequest request1 = new ResourceRequest(1);
        service.allocateResources(request1);
        assertTrue(3 < service.getTotalEnergyConsumption());
        service.releaseResource(request1);
        assertEquals(3, service.getTotalEnergyConsumption());
    }

    @Test
    public void testOptimizeRestart() {
        ResourceRequest request1 = new ResourceRequest(1);
        ResourceRequest request2 = new ResourceRequest(4);
        service.allocateResources(request1);
        service.allocateResources(request2);
        service.optimize(new RestartOptimizationStrategy());
        assertEquals(3, service.getTotalEnergyConsumption());
    }
    @Test
    public void testMain() {
        ResourceRequest request1 = new ResourceRequest(1);
        ResourceRequest request2 = new ResourceRequest(2);
        ResourceRequest request3 = new ResourceRequest(3);
        ResourceRequest request4 = new ResourceRequest(4);
        ResourceRequest request5 = new ResourceRequest(5);

        service.allocateResources(request1);
        service.allocateResources(request2);
        service.allocateResources(request3);
        service.allocateResources(request4);
        service.allocateResources(request5);
        System.out.println("Before load balancing: " + service.getTotalEnergyConsumption());
//        Doesnt guarantee better energy consumption
        service.optimize(new LoadBalancingOptimizationStrategy());
        System.out.println("After Load balancing: " + service.getTotalEnergyConsumption());
        service.optimize(new EnergyEfficencyOptimizationStrategy());
        System.out.println("After Energy Efficient balancing: " + service.getTotalEnergyConsumption());
        service.optimize(new RestartOptimizationStrategy());
        System.out.println("After restart: " + service.getTotalEnergyConsumption());
    }

}