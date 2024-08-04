import faang.school.godbless.BJS2_19192.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataCenterServiceTest {
    private DataCenter dataCenter;
    private DataCenterService service;
    private LoadBalancingOptimizationStrategy loadBalancingStrategy;
    private EnergyEfficencyOptimizationStrategy energyEfficencyStrategy;

    @BeforeEach
    void setUp() {
        dataCenter = new DataCenter();
        loadBalancingStrategy = new LoadBalancingOptimizationStrategy();
        energyEfficencyStrategy = new EnergyEfficencyOptimizationStrategy();
        service = new DataCenterService(dataCenter, loadBalancingStrategy, energyEfficencyStrategy);

        dataCenter.getServerList().add(new Server(5, 10, 100));
        dataCenter.getServerList().add(new Server(7, 10, 200));
        dataCenter.getServerList().add(new Server(8, 10, 150));
        dataCenter.getServerList().add(new Server(4, 10, 180));
        dataCenter.getServerList().add(new Server(6, 10, 110));
    }

    @Test
    void testAddServer() {
        Server newServer = new Server(3, 10, 120);
        service.addServer(newServer);
        assertTrue(dataCenter.getServerList().contains(newServer));
    }

    @Test
    void testRemoveServer() {
        Server serverToRemove = dataCenter.getServerList().get(0);
        service.removeServerByParam(serverToRemove);
        assertFalse(dataCenter.getServerList().contains(serverToRemove));
    }

    @Test
    void testGetTotalEnergyConsumption() {
        double totalEnergy = service.getTotalEnergyConsumption();
        assertEquals(740, totalEnergy);
    }

    @Test
    void testAllocateResources() {
        ResourceRequest request = new ResourceRequest(10);
        service.allocateResources(request);
        assertEquals(0, request.getLoad());
        assertEquals(40, dataCenter.getTotalLoad());
    }

    @Test
    void testReleaseResources() {
        ResourceRequest request = new ResourceRequest(5);
        service.releaseResources(request);
        assertEquals(0, request.getLoad());
        assertEquals(25, dataCenter.getTotalLoad());
    }

    @Test
    void testOptimizeLoadBalancing() {
        dataCenter.getServerList().get(0).setLoad(20);
        service.optimize();
        double totalLoad = dataCenter.getTotalLoad();
        double expectedLoad = totalLoad / dataCenter.getServerList().size();
        for (Server server : dataCenter.getServerList()) {
            assertEquals(expectedLoad, server.getLoad());
        }
    }

    @Test
    void testOptimizeEnergyEfficiency() {
        dataCenter.getServerList().get(0).setEnergyConsumption(500);
        service.optimize();
        double totalEnergy = dataCenter.getTotalEnergy();
        double expectedEnergy = totalEnergy / dataCenter.getServerList().size();
        for (Server server : dataCenter.getServerList()) {
            assertEquals(expectedEnergy, server.getEnergyConsumption());
        }
    }

    @Test
    void testCoefficientOfLoadDistribution() {
        double coefficient = dataCenter.coefficientOfLoadDistribution();
        assertTrue(coefficient >= 0.0 && coefficient <= 1.0);
    }

    @Test
    void testCoefficientOfEnergyDistribution() {
        double coefficient = dataCenter.coefficientOfEnergyDistribution();
        assertTrue(coefficient >= 0.0 && coefficient <= 1.0);
    }
}
