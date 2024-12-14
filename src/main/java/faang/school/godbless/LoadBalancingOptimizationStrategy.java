package faang.school.godbless;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        double optimalShareOfLoad = dataCenter.getTotalCurrentLoad() / dataCenter.getTotalMaxLoad();
        for (Server server : dataCenter.getServerList()) {
            server.setLoad(optimalShareOfLoad * server.getMaxLoad());
        }
    }
}
