package school.faang.bjs2_68888;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0;
        double maxLoad = 0;
        for (Server server : dataCenter.servers) {
            totalLoad += server.getLoad();
            maxLoad += server.getMaxLoad();
        }
        double shareOfMaxLoad = totalLoad / maxLoad;
        log.info("Percentage load is {}", shareOfMaxLoad);
        for (Server server : dataCenter.servers) {
            server.setLoad(server.getMaxLoad() * shareOfMaxLoad);
        }
    }
}
