package data.optimization.test;

import data.optimization.DataCenter;
import data.optimization.DataCenterService;
import data.optimization.ResourceRequest;
import data.optimization.Server;
import data.optimization.optim.strategy.OptimizationStrategy;
import data.optimization.optim.strategy.SillyOptimizationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SillyOptimizationStrategyTest {
    private DataCenter dataCenter;
    private OptimizationStrategy sillyStrategy;

    @Test
    @DisplayName("Testing optimize method")
    void sillyStrategyTest_optimize() {
        dataCenter = new DataCenter();
        sillyStrategy = new SillyOptimizationStrategy();
        Server server1 = new Server(8, 1);
        Server server2 = new Server(4, 1);
        Server server3 = new Server(6, 1);
        DataCenterService.addServer(dataCenter, server1);
        DataCenterService.addServer(dataCenter, server2);
        DataCenterService.addServer(dataCenter, server3);
        ResourceRequest request1 = new ResourceRequest(4);
        ResourceRequest request2 = new ResourceRequest(4);
        ResourceRequest request3 = new ResourceRequest(4);
        DataCenterService.allocateResource(dataCenter, request1);
        DataCenterService.allocateResource(dataCenter, request2);
        DataCenterService.allocateResource(dataCenter, request3);
        double oldLoadBalance = 0;
        for (Server server : dataCenter.getServerLoadsMap().keySet()) {
            oldLoadBalance += server.getLoad() / server.getMaxLoad();
        }
        oldLoadBalance /= dataCenter.getServerLoadsMap().size();

        sillyStrategy.optimize(dataCenter);
        double newLoadBalance = 0;
        for (Server server : dataCenter.getServerLoadsMap().keySet()) {
            newLoadBalance += server.getLoad() / server.getMaxLoad();
        }
        newLoadBalance /= dataCenter.getServerLoadsMap().size();

        assertTrue(newLoadBalance <= oldLoadBalance);
    }

    @Test
    @DisplayName("Testing optimize method with null Arguments")
    void sillyStrategyTest_optimizeWithNullArguments() {
        sillyStrategy = new SillyOptimizationStrategy();
        assertThrows(NullPointerException.class, () -> sillyStrategy.optimize(null));
    }
}
