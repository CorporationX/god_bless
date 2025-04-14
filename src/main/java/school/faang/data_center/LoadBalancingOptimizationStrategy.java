package school.faang.data_center;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double percentageLoaded = dataCenter.getPercentageLoad();
        dataCenter.getServers().forEach(server -> server.setLoad(percentageLoaded * server.getMaxLoad()));
    }
}
