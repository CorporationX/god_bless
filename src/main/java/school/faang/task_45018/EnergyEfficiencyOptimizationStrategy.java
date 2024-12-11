package school.faang.task_45018;

import java.util.List;
import java.util.OptionalDouble;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        OptionalDouble averageEnergyConsumption = servers.stream()
                .mapToDouble(Server::getEnergyConsumption)
                .average();

        if (averageEnergyConsumption.isPresent()) {
            for (Server server : servers) {
                server.setEnergyConsumption(averageEnergyConsumption.getAsDouble());
            }
        }
    }
}