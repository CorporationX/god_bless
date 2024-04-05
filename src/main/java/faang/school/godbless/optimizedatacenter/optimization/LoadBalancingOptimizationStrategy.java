package faang.school.godbless.optimizedatacenter.optimization;

import faang.school.godbless.optimizedatacenter.DataCenter;
import faang.school.godbless.optimizedatacenter.Server;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter.getSERVERS().isEmpty()) {
            return;
        }

        double totalLoad = 0;
        double totalMaxLoad = 0;

        for (Server server : dataCenter.getSERVERS()) {
            totalLoad += server.getLoad();
            totalMaxLoad += server.getMaxLoad();
        }

        double percentageLoad = totalLoad / totalMaxLoad;
        for (Server server : dataCenter.getSERVERS()) {
            server.setLoad(server.getLoad() * percentageLoad);
        }
    }
}
