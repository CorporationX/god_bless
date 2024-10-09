package dima.evseenko.data.strategy;

import dima.evseenko.data.DataCenter;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double averageLoadPercentage = dataCenter.getAverageLoadPercentage();
        dataCenter.getServers().forEach(server -> {
            server.setEnergyConsumption(dataCenter.getServerEnergyConsumptionByServerPercentage(server, averageLoadPercentage));
            server.setLoad(dataCenter.getServerLoadByPercentage(server, averageLoadPercentage));
        });
    }
}
