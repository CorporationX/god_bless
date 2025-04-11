package school.faang.data_center.optimization_strategy;

import school.faang.data_center.model.DataCenter;
import school.faang.data_center.model.Server;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getAllServers();

        if (servers.isEmpty()) {
            return;
        }

        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double totalCapacity = servers.stream().mapToDouble(Server::getMaxLoad).sum();
        double targetUsage = totalLoad / totalCapacity;

        if (totalLoad > totalCapacity) {
            System.out.println("Ошибка: Общая нагрузка превышает возможности серверов!");
            return;
        }

        for (Server s : servers) {
            double targetLoad = s.getMaxLoad() * targetUsage;
            s.setLoad(targetLoad);
        }
    }
}

