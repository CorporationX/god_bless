package school.faang.datacenter.optimization;

import school.faang.datacenter.domain.DataCenter;
import school.faang.datacenter.domain.ResourceRequest;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        var numberOfServers = dataCenter.getServers().size();
        var resourcePerServer = dataCenter.getCurrentLoad() / numberOfServers;
        for (var server : dataCenter.getServers()) {
            server.setLoad(resourcePerServer);
        }
    }
}
