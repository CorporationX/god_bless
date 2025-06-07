package school.faang.data_center;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        for (Server server : dataCenter.getServerList()) {
            if (server.getLoad() == 0.0) {
                server.setEnergyConsumption(0.0);
            }
        }
    }
}
