package school.faang.task_45019;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0);
            }
        }
    }

}
