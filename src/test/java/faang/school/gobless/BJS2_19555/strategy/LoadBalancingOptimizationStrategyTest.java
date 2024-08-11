package faang.school.gobless.BJS2_19555.strategy;

import faang.school.godbless.BJS2_19555.DataCenter;
import faang.school.godbless.BJS2_19555.Server;
import faang.school.godbless.BJS2_19555.strategy.LoadBalancingOptimizationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoadBalancingOptimizationStrategyTest {
    private DataCenter dataCenter;
    private Server server1;
    private Server server2;
    private LoadBalancingOptimizationStrategy strategy;

    @BeforeEach
    void setUp() {
        dataCenter = mock(DataCenter.class);
        server1 = mock(Server.class);
        server2 = mock(Server.class);
        strategy = new LoadBalancingOptimizationStrategy();
    }

    @Test
    void testOptimize() {
        when(server1.getMaxLoad()).thenReturn(20d);
        when(server1.getLoad()).thenReturn(12d);
        when(server1.getAvailableLoad()).thenReturn(8d);
        when(server1.increaseLoad(1)).thenReturn(13d);
        when(server2.getMaxLoad()).thenReturn(26d);
        when(server2.getLoad()).thenReturn(24d);
        when(server2.getAvailableLoad()).thenReturn(2d);
        when(server2.decreaseLoad(1d)).thenReturn(23d);
        when(dataCenter.getServers()).thenReturn(Arrays.asList(server1, server2));

        strategy.optimize(dataCenter);

        verify(server1).increaseLoad(1);
        verify(server1).changeEnergyConsumption(12d, 13d);
        verify(server2).decreaseLoad(1);
        verify(server2).changeEnergyConsumption(24d, 23d);
    }
}
