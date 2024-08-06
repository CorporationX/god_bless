package faang.school.godbless.datacenter.services;

import faang.school.godbless.datacenter.entities.DataCenter;
import faang.school.godbless.datacenter.entities.ResourceRequest;
import faang.school.godbless.datacenter.entities.Server;
import faang.school.godbless.datacenter.exceptions.ResourceAllocateException;
import faang.school.godbless.datacenter.exceptions.ResourceReleaseExceptions;
import faang.school.godbless.datacenter.optimization.EnergyEfficencyOptimizationStrategy;
import faang.school.godbless.datacenter.optimization.LoadBalancingOptimizationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {
    private DataCenterService dataCenterService;
    List<Server> servers;
    private Server server1;
    private Server server2;

    @BeforeEach
    void setUp() {
        servers = new ArrayList<>(List.of(
                server1 = new Server(100.0, 200.0, 100.0),
                server2 = new Server(5.0, 10.0, 5.0)
        ));

        DataCenter dataCenter = new DataCenter(servers);
        dataCenterService = new DataCenterService(dataCenter);
    }

    @Nested
    class PositiveTests {
        @Test
        void addServerTest_Success() {
            var server3 = new Server(1.0, 10.0, 5.0);

            dataCenterService.addServer(server3);

            assertEquals(1.0, server3.getLoad());
            assertEquals(10.0, server3.getMaxLoad());
            assertEquals(5.0, server3.getEnergyConsumption());
            assertEquals(3, servers.size());
        }

        @Test
        void removeServerTest_Success() {
            dataCenterService.removeServer(server2);

            assertEquals(1, servers.size());
        }

        @Test
        void getTotalEnergyConsumptionTest_Success() {
            var energyConsumptionSum = server1.getEnergyConsumption() + server2.getEnergyConsumption();

            assertEquals(energyConsumptionSum, dataCenterService.getTotalEnergyConsumption());
        }

        @Test
        void allocateResourcesTest_Success() {
            dataCenterService.allocateResources(new ResourceRequest(50));

            assertEquals(150, server1.getLoad());
        }

        @Test
        void releaseResources_Success() {
            dataCenterService.releaseResources(new ResourceRequest(40));

            assertEquals(60, server1.getLoad());
        }


        @Test
        void optimizeWithLoadBalancingOptimizationStrategy_Success() {
            dataCenterService.optimizeDataCenter(new LoadBalancingOptimizationStrategy());

            assertEquals(100, server1.getLoad());
            assertEquals(5, server2.getLoad());
        }

        @Test
        void optimizeWithEnergyEfficencyOptimizationStrategy_Success() {
            dataCenterService.optimizeDataCenter(new EnergyEfficencyOptimizationStrategy());

            assertEquals(100, server1.getLoad());
            assertEquals(5, server2.getLoad());
        }

        @Nested
        class NegativeTests {

            @Test
            void allocateResourcesTest_EmptyServers_throwResourceAllocateException() {
                dataCenterService.removeServer(server1);
                dataCenterService.removeServer(server2);

                assertThrows(ResourceAllocateException.class,
                        () -> dataCenterService.allocateResources(new ResourceRequest(50)));
            }

            @Test
            void allocateResourcesTest_BigRequestLoad_throwResourceAllocateException() {
                assertThrows(ResourceAllocateException.class,
                        () -> dataCenterService.allocateResources(new ResourceRequest(1000)));
            }

            @Test
            void releaseResourcesTest_EmptyServers_throwResourceReleaseExceptions() {
                dataCenterService.removeServer(server1);
                dataCenterService.removeServer(server2);

                assertThrows(ResourceReleaseExceptions.class,
                        () -> dataCenterService.releaseResources(new ResourceRequest(50)));
            }

            @Test
            void releaseResourcesTest_BigRequestLoad_throwResourceReleaseExceptions() {
                assertThrows(ResourceReleaseExceptions.class,
                        () -> dataCenterService.releaseResources(new ResourceRequest(1000)));
            }

            @Test
            void releaseResourcesTest_RequestLoadBiggerThanAvailableLoad_throwResourceReleaseExceptions() {
                assertNotEquals(0, server1.getLoad());

                dataCenterService.releaseResources(new ResourceRequest(120));

                assertEquals(0, server1.getLoad());
            }
        }
    }
}
