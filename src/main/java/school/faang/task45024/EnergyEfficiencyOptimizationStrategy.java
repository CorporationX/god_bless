package school.faang.task45024;

import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {

        List<Server> servers = dataCenter.getServers();

        double average = servers
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum() / servers.size();

        servers.forEach(server -> server.setEnergyConsumption(average));
    }
}
