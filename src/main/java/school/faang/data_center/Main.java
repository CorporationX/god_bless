package school.faang.data_center;

import school.faang.data_center.model.DataCenter;
import school.faang.data_center.model.ResourceRequest;
import school.faang.data_center.model.Server;
import school.faang.data_center.optimization_strategy.EnergyEfficiencyOptimizationStrategy;
import school.faang.data_center.optimization_strategy.LoadBalancingOptimizationStrategy;
import school.faang.data_center.optimization_strategy.OptimizationStrategy;
import school.faang.data_center.service.DataCenterService;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = initializeDataCenter();
        DataCenterService dataCenterService = new DataCenterService();

        testResourceAllocation(dataCenterService, dataCenter, 15);

        testOptimizationStrategy(dataCenterService, dataCenter,
                new LoadBalancingOptimizationStrategy(), "Load Balancing");

        testOptimizationStrategy(dataCenterService, dataCenter,
                new EnergyEfficiencyOptimizationStrategy(), "Energy Efficiency");

        dataCenterService.releaseResources(dataCenter, new ResourceRequest(15));
        System.out.println(dataCenterService.getTotalEnergyConsumption(dataCenter));
    }

    private static DataCenter initializeDataCenter() {
        DataCenter dataCenter = new DataCenter();
        dataCenter.addAllServers(
                new Server(2, 10),
                new Server(5, 20),
                new Server(4, 20)
        );
        return dataCenter;
    }

    private static void testResourceAllocation(DataCenterService service,
                                               DataCenter dataCenter,
                                               int requestedResources) {
        ResourceRequest request = new ResourceRequest(requestedResources);
        boolean isAllocated = service.allocateResources(dataCenter, request);

        System.out.printf("Resource allocation (%d units): %s%n%n",
                requestedResources,
                isAllocated ? "SUCCESS" : "FAILED");
    }

    private static void testOptimizationStrategy(DataCenterService service,
                                                 DataCenter dataCenter,
                                                 OptimizationStrategy strategy,
                                                 String strategyName) {
        System.out.println("=== Before " + strategyName + " Optimization ===");
        printServers(dataCenter);

        service.setOptimizationStrategy(strategy);
        service.optimizeResources(dataCenter);

        System.out.println("=== After " + strategyName + " Optimization ===");
        printServers(dataCenter);
        System.out.println();
    }

    private static void printServers(DataCenter dataCenter) {
        System.out.println("Current servers state:");
        dataCenter.getAllServers().forEach(System.out::println);
    }
}
