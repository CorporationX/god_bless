package derschrank.sprint01.task12.bjstwo_45017.optimization;

import derschrank.sprint01.task12.bjstwo_45017.DataCenter;
import derschrank.sprint01.task12.bjstwo_45017.servers.Server;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = dataCenter.getTotalLoad();
        double moreNeedResource = totalLoad;

        for (Server server : dataCenter.getServers()) {
            if (moreNeedResource > 0) {
                if (!server.isOn()) {
                    server.switchOn();
                }
                double resourceFromThisServer = server.getMaxLoad();
                server.setLoad(Math.min(resourceFromThisServer, moreNeedResource));

                moreNeedResource -= server.getLoad();
            } else {
                if (server.isOn()) {
                    server.switchOff();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "EnergyEfficiencyOptimizationStrategy";
    }
}
