package school.faang.bjs245028.balancer;

import school.faang.bjs245028.model.DataCenter;
import school.faang.bjs245028.model.Server;

import java.util.Comparator;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter.getServers() == null || dataCenter.getServers().isEmpty()) {
            throw new RuntimeException("Нет серверов!");
        }

        double totalLoad = dataCenter.getServers().stream()
                .mapToDouble(Server::getLoad)
                .sum();

        dataCenter.getServers().sort(Comparator.comparingDouble(Server::getMaxLoad));

        for (Server server : dataCenter.getServers()) {
            double availableCapacity = server.getMaxLoad() - server.getLoad();
            if (totalLoad <= availableCapacity) {
                server.setLoad(server.getLoad() + totalLoad);
                totalLoad = 0;
                break;
            } else {
                server.setLoad(server.getMaxLoad());
                totalLoad -= availableCapacity;
            }
        }


        if (totalLoad > 0) {
            throw new RuntimeException("Невозможно оптимизировать нагрузку, не хватает серверных ресурсов!");
        }
    }
}