package faang.school.godbless.optimizingDataCenter;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalConsumption = 0;
        double maxLoad = 0;
        for (Server server : dataCenter.getServers()) {
            totalConsumption += server.getEnergyConsumption();
            maxLoad += server.getMaxLoad();
        }
        double average = totalConsumption / maxLoad;
        for (Server server : dataCenter.getServers()) {
            server.setLoad(server.getMaxLoad() * average);
        }
    }
}
