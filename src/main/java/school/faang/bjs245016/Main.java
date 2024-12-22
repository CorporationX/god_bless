package school.faang.bjs245016;

import school.faang.bjs245016.optimizationstrategies.EnergyEfficiencyOptimizationStrategy;

public class Main {
    public static void main(String[] args) {
        OptimizationStrategy strategy = new EnergyEfficiencyOptimizationStrategy();
        DataCenterService datacenterservice = new DataCenterService(strategy);
        datacenterservice.addServer("Server1", 10, 100, 10000);
        datacenterservice.addServer("Server2", 20, 200, 20000);
        datacenterservice.allocateResources(new ResourceRequest(85, null));
        datacenterservice.optimizeDatacenter();
    }
}
