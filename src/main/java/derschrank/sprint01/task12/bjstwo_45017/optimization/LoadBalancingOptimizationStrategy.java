package derschrank.sprint01.task12.bjstwo_45017.optimization;

import derschrank.sprint01.task12.bjstwo_45017.DataCenter;
import derschrank.sprint01.task12.bjstwo_45017.servers.Server;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = dataCenter.getTotalLoad();
        double totalMaxLoad = dataCenter.getTotalMaxLoad();
        double coefficient = totalLoad / totalMaxLoad;

        double moreNeedResource = totalLoad;
        for (Server server : dataCenter.getServers()) {
            if (!server.isOn()) {
                server.switchOn();
            }

            double maxLoad = server.getMaxLoad();
            double resourceFromThisServer = Math.ceil(maxLoad * coefficient);
            server.setLoad(Math.min(resourceFromThisServer, moreNeedResource));

            moreNeedResource -= server.getLoad();
        }
    }

    @Override
    public String toString() {
        return "LoadBalancingOptimizationStrategy";
    }
}
