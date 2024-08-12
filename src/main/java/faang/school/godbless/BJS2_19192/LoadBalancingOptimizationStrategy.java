package faang.school.godbless.BJS2_19192;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = dataCenter.getTotalLoad();
        dataCenter.clearLoad();
        double avg = totalLoad / dataCenter.getServerList().size();

        for (var server : dataCenter.getServerList()) {
            server.setLoad(avg);
        }
    }
}
