package school.faang.task_45026.strategy;

import school.faang.task_45026.entity.Server;
import school.faang.task_45026.repository.DataCenter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter == null) {
            throw new IllegalArgumentException("Data center is null");
        }

        List<Server> servers = dataCenter.getServers();


        BigDecimal currentLoad = BigDecimal.valueOf(servers.stream()
                .mapToDouble(Server::getLoad)
                .sum());
        BigDecimal currentMaxLoad = BigDecimal.valueOf(servers.stream()
                .mapToDouble(Server::getMaxLoad)
                .sum());

        BigDecimal loadRate = currentLoad.divide(currentMaxLoad, 15, RoundingMode.HALF_UP);

        for (Server server : servers) {
            BigDecimal loadToRate = loadRate.multiply(BigDecimal.valueOf(server.getMaxLoad()));
            server.setLoad(loadToRate.doubleValue());
            currentLoad = currentLoad.subtract(loadToRate);
        }
    }
}
