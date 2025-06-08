package school.faang.datacenter.optimization;

import school.faang.datacenter.domain.DataCenter;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        var dataCenterReallocateLoad = dataCenter.getCurrentLoad();
        for (var server : dataCenter.getServers()) {
            var loadToReallocate = server.getMaxLoad() - server.getLoad();
            if (loadToReallocate != 0 && dataCenterReallocateLoad != 0) {
                server.setLoad(server.getMaxLoad());
                dataCenterReallocateLoad -= loadToReallocate;
            } else {
                server.setLoad(0);
            }
        }
    }
}
