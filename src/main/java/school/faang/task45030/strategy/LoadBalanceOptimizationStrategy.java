package school.faang.task45030.strategy;

import school.faang.task45030.model.DataCenter;
import school.faang.task45030.model.Server;

import java.util.List;

public class LoadBalanceOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServerList();
        double totalLoad = 0;
        int avaibleServers = 0;

        for (Server server : servers) {
            if (server.getEnergyConsumption() > 0) {
                totalLoad += server.getLoad();
                avaibleServers++;
            }
        }

        double averageLoad = totalLoad / avaibleServers;
        for (Server server : servers) {
            if (server.getEnergyConsumption() > 0) {
                server.setLoad(averageLoad);
            }
        }
    }
}
