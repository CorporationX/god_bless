package school.faang.bjs2_79739;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        dataCenter.getServers().forEach(server -> {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0.0);
            }
        });
    }
}
