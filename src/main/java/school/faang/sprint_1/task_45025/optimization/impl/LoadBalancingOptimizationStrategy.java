package school.faang.sprint_1.task_45025.optimization.impl;

import school.faang.sprint_1.task_45025.data_center.DataCenter;
import school.faang.sprint_1.task_45025.exceptions.LoadOverflowException;
import school.faang.sprint_1.task_45025.models.Server;
import school.faang.sprint_1.task_45025.optimization.OptimizationStrategy;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) throws LoadOverflowException {
        List<Server> servers = dataCenter.getServers();
        double totalMaxLoad = servers.stream().mapToDouble(Server::getMaxLoad).sum();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double loadRation = totalLoad / totalMaxLoad;
        if (loadRation >= 1) {
            throw new LoadOverflowException(totalLoad - totalMaxLoad);
        }

        double remainLoad = totalLoad;

        for (var server : servers) {
            int balanceLoad = (int) (server.getMaxLoad() * loadRation);
            server.setLoad(balanceLoad);
            remainLoad -= balanceLoad;
        }

        for (var server : servers) {
            if (remainLoad == 0) {
                break;
            }
            var availableLoad = server.getMaxLoad() - server.getLoad();
            if (availableLoad > 0) {
                double subtractiveLoad = Math.min(availableLoad, remainLoad);
                remainLoad -= subtractiveLoad;
                server.setLoad(server.getMaxLoad() - availableLoad + subtractiveLoad);
            }
        }
    }
}
