package faang.school.godbless.BJS28666;

import java.util.Comparator;
import java.util.List;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        if (dataCenter.getTotalEnergyConsumption() == 0) {
            return;
        }

        servers.sort(Comparator.comparing(Server::getEnergyConsumption).reversed());
        for (int i = 0; i < servers.size(); i++) {
            for (int j = servers.size() - 1; j > i; j--) {
                if (servers.get(i).isFullRedistributeSuccess(servers.get(j))) {
                    break;
                }
            }
        }
    }
}
