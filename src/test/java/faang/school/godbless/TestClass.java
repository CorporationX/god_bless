package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestClass {
    DataCenterService datacenterService;
    DataCenter datacenter;
    @BeforeEach
    void SetUp() {
        datacenterService = new DataCenterService();
        datacenter = new DataCenter();
    }

    @Test
    @DisplayName("Test create Server")
    void testCreateServer() {
        datacenterService.addServer(datacenter,"ABC",10000,3000);
        assertEquals(datacenter.countFreeRPS(),10000);
    }
    @Test
    @DisplayName("Test alloc res")
    void testAllocRes() {
        datacenterService.addServer(datacenter, "ABC",10000,3000);
        datacenterService.allocateResources(datacenter, new ResourceRequest(8000));
        assertEquals(datacenter.countFreeRPS(),2000);
    }
    @Test
    @DisplayName("Test remove server")
    void testRemoveServer() {
        datacenterService.addServer(datacenter,"ABC",10000,3000);
        datacenterService.removeServer(datacenter,"ABC");
        assertEquals(datacenter.countFreeRPS(),0);
    }
    @Test
    @DisplayName("Test remove server with exception")
    void testException() {
        datacenterService.addServer(datacenter,"ABC",10000,3000);
        datacenterService.allocateResources(datacenter, new ResourceRequest(8000));
        assertThrows(RuntimeException.class, ()->datacenterService.removeServer(datacenter,"ABC"));
    }
    @Test
    @DisplayName("Test remove server with exception message")
    void testRemoveException() {
        datacenterService.addServer(datacenter,"ABC",10000,3000);
        Throwable exception = assertThrows(RuntimeException.class, () -> datacenterService.removeServer(datacenter,"1C2"));
        assertEquals("No such server", exception.getMessage());
    }
    @Test
    @DisplayName("Test optimization and energy")
    void testOptimizationEnergy() {
        datacenterService.addServer(datacenter,"ABC",10000,4000);
        datacenterService.addServer(datacenter,"DEF",8000,3000);
        datacenterService.allocateResources(datacenter, new ResourceRequest(9000));
        LoadBalancingOptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();
        strategy.optimize(datacenter);
        assertEquals(datacenter.servers.get("ABC").getLoad(),5000);
        assertEquals(datacenter.servers.get("ABC").getEnergyConsumption(),19000);
    }
}
