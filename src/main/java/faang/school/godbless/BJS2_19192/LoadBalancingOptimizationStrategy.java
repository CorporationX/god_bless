package faang.school.godbless.BJS2_19192;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = dataCenter.getTotalLoad();
        dataCenter.clearLoad();
        double avg = totalLoad / dataCenter.serverList.size();

        for (var server : dataCenter.serverList) {
            server.setLoad(avg);
        }
    }
}
