package school.faang.datacenter;

import java.util.Comparator;
import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.servers();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();

        servers.forEach(server -> server.setLoad(0));

        for (Server server : servers) {
            if (totalLoad > server.getMaxLoad()) {
                server.setLoad(server.getMaxLoad());
                totalLoad -= server.getMaxLoad();
            } else {
                server.setLoad(totalLoad);
                totalLoad = 0;
            }
            server.setEnergyConsumption(server.getLoad(), server.getMaxLoad());

            if (totalLoad == 0) {
                break;
            }
        }
    }
}
