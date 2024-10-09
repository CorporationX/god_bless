package dima.evseenko.data.strategy;

import dima.evseenko.data.DataCenter;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double averageAverageEnergyConsumption = dataCenter.getAverageEnergyConsumption();
        dataCenter.getServers().forEach(server -> {
            if ((dataCenter.getServerLoadByEnergyConsumption(server, averageAverageEnergyConsumption) < server.getMaxLoad())) {
                server.setLoad((dataCenter.getServerLoadByEnergyConsumption(server, averageAverageEnergyConsumption)));
                server.setEnergyConsumption(averageAverageEnergyConsumption);
            }
        });
    }
}
