package faang.school.godbless;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        Collections.sort(dataCenter.getServerList(), Comparator.comparingDouble(Server::getEnergyConsumption));

        double currentLoad = dataCenter.getTotalCurrentLoad();
        for (Server server : dataCenter.getServerList()) {
            if (currentLoad == 0) {
                return;
            } else {
                currentLoad -= (server.getMaxLoad() - server.getLoad());
                server.setLoad(server.getMaxLoad());
            }
        }
    }
}
