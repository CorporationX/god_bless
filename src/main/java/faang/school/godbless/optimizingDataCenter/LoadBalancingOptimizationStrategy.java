package faang.school.godbless.optimizingDataCenter;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0;
        double maxLoad = 0;
        for (Server server : dataCenter.getServers()) {
            totalLoad += server.getLoad();
            maxLoad += server.getMaxLoad();
        }
        double average = totalLoad / maxLoad;
        for (Server server : dataCenter.getServers()) {
            server.setEnergyConsumption(server.getMaxLoad() * average);
        }
    }
}
