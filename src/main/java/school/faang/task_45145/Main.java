package school.faang.task_45145;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_45145.models.DataCenter;
import school.faang.task_45145.models.ResourceRequest;
import school.faang.task_45145.models.Server;
import school.faang.task_45145.services.DataCenterService;
import school.faang.task_45145.strategies.EnergyEfficiencyOptimizationStrategy;
import school.faang.task_45145.strategies.LoadBalancingOptimizationStrategy;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("\n=== [Mars Data Center] Overview ===");
        final DataCenter marsDataCenter = new DataCenter("Mars");
        final DataCenterService marsDataCenterService = new DataCenterService(marsDataCenter);

        final Server primeServer = new Server("Prime", 70.0, 200.0, 25.0);
        final Server bumblebeeServer = new Server("Bumblebee", 130.0, 150.0, 30.0);
        final Server optimusServer = new Server("Optimus", 150.0, 300.0, 35.0);

        marsDataCenterService.addServer(primeServer);
        marsDataCenterService.addServer(bumblebeeServer);
        marsDataCenterService.addServer(optimusServer);
        marsDataCenterService.addServer(primeServer);
        marsDataCenterService.removeServer(primeServer);
        marsDataCenterService.removeServer(primeServer);

        marsDataCenterService.getTotalEnergyConsumption();

        log.info("\n\n=== [Empty Data Center] Overview ===");
        final var emptyDataCenter = new DataCenter("Empty");
        final var emptyDataCenterService = new DataCenterService(emptyDataCenter);
        emptyDataCenterService.getTotalEnergyConsumption();

        log.info("\n\n=== Resource Request Processing ===");
        final var resourceRequest = new ResourceRequest(50.0);
        marsDataCenterService.allocateResources(resourceRequest);
        marsDataCenterService.releaseResources(resourceRequest);

        log.info("\n\n=== Optimization Operations ===");
        marsDataCenterService.optimize();

        log.info("\n\n=== Applying Load Balancing Strategy ===");
        LoadBalancingOptimizationStrategy loadBalancingOptimizationStrategy = new LoadBalancingOptimizationStrategy();
        marsDataCenterService.setOptimizationStrategy(loadBalancingOptimizationStrategy);
        marsDataCenterService.optimize();
        log.debug("{}\n", marsDataCenter);

        log.info("\n\n=== Applying Energy Efficiency Strategy ===");
        marsDataCenterService.releaseResources(new ResourceRequest(200));
        var energyEfficiencyOptimizationStrategy = new EnergyEfficiencyOptimizationStrategy();
        marsDataCenterService.setOptimizationStrategy(energyEfficiencyOptimizationStrategy);
        marsDataCenterService.optimize();
        log.debug("{}", marsDataCenter);

        log.info("\n\n=== Cyclic Optimization Process ===");
        marsDataCenterService.setOptimizationStrategy(loadBalancingOptimizationStrategy);
        marsDataCenterService.startPeriodicOptimization(5000);
        log.debug("{}", marsDataCenter);
    }
}
