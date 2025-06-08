package school.faang.datacenter.optimization;

import school.faang.datacenter.domain.DataCenter;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        var loadToReallocate = dataCenter.getCurrentLoad();
        for (var server : dataCenter.getServers()) {
            loadToReallocate -= server.getMaxLoad() - server.getLoad();
            if (loadToReallocate == 0) {
                server.setLoad(0);
            } else {
                server.setLoad(server.getMaxLoad());
            }
        }
    }
}
