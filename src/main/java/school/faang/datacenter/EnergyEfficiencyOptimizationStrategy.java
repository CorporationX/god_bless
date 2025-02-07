package school.faang.datacenter;

import java.util.Comparator;
import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();

        servers.sort(Comparator.comparingDouble(Server::getLoad));

        for (Server server : servers) {
            double permissibleLoad = server.getMaxLoad() - server.getLoad();

            if (totalLoad > permissibleLoad) {
                server.setLoad(server.getLoad() + permissibleLoad);
                totalLoad -= permissibleLoad;
            } else {
                server.setLoad(server.getLoad() + (permissibleLoad - totalLoad));
                break;
            }
        }
    }
}
