package faang.school.godbless.BJS2_19396;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        for (Server server : dataCenter.getServers()) {

            double energyConsumption = server.getEnergyConsumption(),
                    maxEnergyConsumption = server.getMaxEnergyConsumption();
            double percentageOfConsumptionFromMaximumConsumption =
                    energyConsumption / maxEnergyConsumption * 100;

            if (percentageOfConsumptionFromMaximumConsumption > 70) {
                double twentyPercentOfConsumption = energyConsumption * 20 / 100;
                server.setEnergyConsumption(energyConsumption - twentyPercentOfConsumption);
            }
        }
    }
}
