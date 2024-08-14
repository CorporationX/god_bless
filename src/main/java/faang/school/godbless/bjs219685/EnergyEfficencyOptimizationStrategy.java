package faang.school.godbless.bjs219685;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter.getTotalLoad() < (dataCenter.getServers().size() - 1) * 100) {
            dataCenter.deleteServer(dataCenter.getServers().remove(0));
        }
    }
}
