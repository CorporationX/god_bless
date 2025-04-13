package optimizingdatacenter;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        dataCenter.getServers().stream()
                .filter(s -> s.getLoad() == 0)
                .forEach(s -> s.setEnergyConsumption(0.00));
    }
}
