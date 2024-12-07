package school.faang.task_45026.strategy;

import school.faang.task_45026.entity.Server;
import school.faang.task_45026.repository.DataCenter;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter == null) {
            throw new IllegalArgumentException("Data center is null");
        }

        List<Server> servers = dataCenter.getServers();

        double currentLoad = servers.stream()
                .mapToDouble(Server::getLoad)
                .sum();
        double currentMaxLoad = servers.stream()
                .mapToDouble(Server::getMaxLoad)
                .sum();

        double loadRate = currentLoad / currentMaxLoad;

        //Мне кажется будет погрешность при расчетах, но не уверен на сколько это критично
        for (Server server : servers) {
            double loadToRate = server.getMaxLoad() * loadRate;
            server.setLoad(loadToRate);
            currentLoad -= loadToRate;
        }
    }
}
