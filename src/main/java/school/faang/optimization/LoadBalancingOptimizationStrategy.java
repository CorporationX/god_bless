package school.faang.optimization;

import java.util.List;
import java.util.logging.Logger;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    private static final Logger logger = Logger.getLogger(LoadBalancingOptimizationStrategy.class.getName());

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        // Проверяем, что список серверов не пустой
        if (servers.isEmpty()) {
            logger.warning("Error: The server list is empty. Optimization is impossible.");
            return;
        }

        // Считаем общую нагрузку
        double totalLoad = 0;
        for (Server server : servers) {
            totalLoad += server.getLoad();
        }

        // Вычисляем среднюю нагрузку
        double averageLoad = totalLoad / servers.size();

        // Распределяем нагрузку
        for (Server server : servers) {
            if (server.getLoad() > averageLoad) {
                double excessLoad = server.getLoad() - averageLoad;
                server.setLoad(averageLoad);

                // Перераспределяем избыточную нагрузку на другие серверы
                for (Server otherServer : servers) {
                    if (otherServer.getLoad() < averageLoad) {
                        double availableCapacity = averageLoad - otherServer.getLoad();
                        if (excessLoad <= availableCapacity) {
                            otherServer.setLoad(otherServer.getLoad() + excessLoad);
                            break;
                        } else {
                            otherServer.setLoad(averageLoad);
                            excessLoad -= availableCapacity;
                        }
                    }
                }
            }
        }
    }
}
