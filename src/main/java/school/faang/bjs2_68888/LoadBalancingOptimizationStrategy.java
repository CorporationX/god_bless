package school.faang.bjs2_68888;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0;
        double maxLoad = 0;
        for (Server server : dataCenter.getServers()) {
            totalLoad += server.getLoad();
            maxLoad += server.getMaxLoad();
        }
        double shareOfMaxLoad = totalLoad / maxLoad;
        log.info("Percentage load is {}", shareOfMaxLoad);
        for (Server server : dataCenter.getServers()) {
            server.setLoad(server.getMaxLoad() * shareOfMaxLoad);
        }
    }
}
