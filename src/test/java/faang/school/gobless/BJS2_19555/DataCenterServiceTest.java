package faang.school.gobless.BJS2_19555;

import faang.school.godbless.BJS2_19555.DataCenter;
import faang.school.godbless.BJS2_19555.DataCenterService;
import faang.school.godbless.BJS2_19555.ResourceRequest;
import faang.school.godbless.BJS2_19555.Server;
import faang.school.godbless.BJS2_19555.strategy.OptimizationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DataCenterServiceTest {
    private DataCenterService dataCenterService;
    private DataCenter dataCenter;
    private Server server;
    private ResourceRequest resourceRequest;
    private Predicate<Server> condition;
    private BiFunction<Server, Double, Double> loadModifier;
    private Timer mockTimer;
    private OptimizationStrategy optimizationStrategy;

    @BeforeEach
    void setUp() {
        mockTimer = mock(Timer.class);
        dataCenterService = new DataCenterService(mockTimer);
        dataCenter = mock(DataCenter.class);
        server = mock(Server.class);
        resourceRequest = mock(ResourceRequest.class);
        condition = mock(Predicate.class);
        loadModifier = mock(BiFunction.class);
        optimizationStrategy = mock(OptimizationStrategy.class);
    }

    @Test
    void testAddServer() {
        Map<Server, Integer> mockServerIndexes = mock(Map.class);
        List<Server> servers = mock(ArrayList.class);
        when(dataCenter.getServers()).thenReturn(servers);
        when(dataCenter.getServerIndexes()).thenReturn(mockServerIndexes);
        when(servers.size()).thenReturn(1);

        dataCenterService.addServer(dataCenter, server);

        verify(servers).add(server);
        verify(mockServerIndexes).put(server, 0);
    }

    @Test
    void testRemoveServer() {
        Map<Server, Integer> mockServerIndexes = mock(Map.class);
        List<Server> servers = new ArrayList<>(Collections.singletonList(server));

        when(mockServerIndexes.remove(server)).thenReturn(0);

        when(dataCenter.getServers()).thenReturn(servers);
        when(dataCenter.getServerIndexes()).thenReturn(mockServerIndexes);

        dataCenterService.removeServer(dataCenter, server);

        verify(mockServerIndexes).remove(server);
        assertTrue(servers.isEmpty());
    }

    @Test
    void testGetTotalEnergyConsumption() {
        when(server.getEnergyConsumption()).thenReturn(100.0);
        List<Server> servers = Collections.singletonList(server);
        when(dataCenter.getServers()).thenReturn(servers);

        double totalEnergy = dataCenterService.getTotalEnergyConsumption(dataCenter);

        assertEquals(100.0, totalEnergy);
    }

    @Test
    void testAllocateResources() {
        when(resourceRequest.getLoad()).thenReturn(50.0);
        when(server.getAvailableLoad()).thenReturn(100.0);
        when(server.getLoad()).thenReturn(0.0);
        when(server.increaseLoad(50.0)).thenReturn(50.0);
        List<Server> servers = Collections.singletonList(server);
        when(dataCenter.getServers()).thenReturn(servers);

        dataCenterService.allocateResources(dataCenter, resourceRequest);

        verify(server).increaseLoad(50.0);
        verify(server).changeEnergyConsumption(0.0, 50);

    }

    @Test
    void testReleaseResources() {
        when(resourceRequest.getLoad()).thenReturn(50.0);
        when(server.getLoad()).thenReturn(100.0);
        when(server.decreaseLoad(50.0)).thenReturn(50.0);

        List<Server> servers = Collections.singletonList(server);
        when(dataCenter.getServers()).thenReturn(servers);

        dataCenterService.releaseResources(dataCenter, resourceRequest);

        verify(server).decreaseLoad(50.0);
        verify(server).changeEnergyConsumption(100.0, 50.0);
    }

    @Test
    void testModifyLoad() {
        when(server.getLoad()).thenReturn(50.0);
        when(resourceRequest.getLoad()).thenReturn(10.0);
        when(condition.test(server)).thenReturn(true);
        when(loadModifier.apply(server, 10.0)).thenReturn(60.0);
        when(dataCenter.getServers()).thenReturn(Collections.singletonList(server));

        dataCenterService.modifyLoad(dataCenter, resourceRequest, condition, loadModifier);

        verify(server).changeEnergyConsumption(50.0, 60.0);
    }

    @Test
    void testOptimize() {
        dataCenterService.optimize(dataCenter, optimizationStrategy);

        verify(mockTimer).scheduleAtFixedRate(any(TimerTask.class), eq(0L), eq(1800000L));
    }
}
