package faang.school.godbless.bjs219685;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = dataCenter.getTotalLoad();
        double averageLoad = totalLoad / dataCenter.getServers().size();
        for (Server server : dataCenter.getServers()) {
            server.setLoad(averageLoad);
        }
    }
}
