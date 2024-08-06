package faang.school.godbless.bjs2_19287;

import lombok.NoArgsConstructor;

import static faang.school.godbless.bjs2_19287.Constants.ALLOWED_UTILIZATION_INTERVAL;
import static faang.school.godbless.bjs2_19287.Constants.DEFAULT_MAX_LOAD;
import static faang.school.godbless.bjs2_19287.Constants.OPTIMAL_OPTIMIZATION;

@NoArgsConstructor
public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    private static final Integer LEFT = ALLOWED_UTILIZATION_INTERVAL.getLeft();
    private static final Integer RIGHT = ALLOWED_UTILIZATION_INTERVAL.getRight();
    private static final Integer OPTIMAL = OPTIMAL_OPTIMIZATION;

    @Override
    public void optimize(DataCenter dataCenter) {
        System.out.println("Energy consumption before optimization: " + dataCenter.getTotalEnergyConsumption());
        optimizeLowUtilizationServers(dataCenter);
        optimizeHighUtilizationServers(dataCenter);
        System.out.println("Energy consumption after optimization:  " + dataCenter.getTotalEnergyConsumption());
    }

    /**
     * Optimize servers where utilization < LEFT
     */
    private void optimizeLowUtilizationServers(DataCenter dataCenter) {
        var servers = dataCenter.getServers();

        var serversToTurnOff = servers.stream()
                .filter(Server::isActive)
                .filter(server -> server.getUtilization() < LEFT)
                .toList();
        var remainingToOptimize = serversToTurnOff.stream().mapToDouble(Server::getLoad).sum();
        var recipientsServers = servers.stream()
                .filter(Server::isActive)
                .filter(server -> server.getUtilization() >= LEFT && server.getUtilization() < RIGHT)
                .toList();
        for (Server server : serversToTurnOff) {
            var currentLoad = server.getLoad();
            for (Server recipient : recipientsServers) {
                var recipientLoad = recipient.getLoad();
                var newRecipientLoad = currentLoad + recipientLoad;
                if (isAllowedUtilization(recipient, newRecipientLoad)) {
                    recipient.increaseLoad(currentLoad);
                    remainingToOptimize = remainingToOptimize - currentLoad;
                    break;
                }
            }
            server.turnOff();
        }
        if (remainingToOptimize > 0) {
            if (remainingToOptimize <= DEFAULT_MAX_LOAD) {
                dataCenter.addServerWithLoadAndTurnOn(remainingToOptimize);
            } else {
                dataCenter.addServerWithCustomMaxLoadWithLoadAndTurnOn(remainingToOptimize); // or to some default servers
            }
        }
    }

    /**
     * Optimize servers where utilization >= RIGHT
     */
    private void optimizeHighUtilizationServers(DataCenter dataCenter) {
        var servers = dataCenter.getServers();

        var serversToDecrease = servers.stream()
                .filter(Server::isActive)
                .filter(server -> server.getUtilization() >= RIGHT)
                .toList();
        var remainingToOptimize = serversToDecrease.stream()
                .mapToDouble(server -> server.getLoad() - OPTIMAL)
                .sum();
        var recipientsServers = servers.stream()
                .filter(Server::isActive)
                .filter(server -> server.getUtilization() >= LEFT && server.getUtilization() < RIGHT)
                .toList();
        for (Server server : serversToDecrease) {
            var currentLoad = server.getLoad();
            var loadToDecrease = currentLoad - OPTIMAL;
            for (Server recipient : recipientsServers) {
                var recipientLoad = recipient.getLoad();
                var newRecipientLoad = loadToDecrease + recipientLoad;
                if (isAllowedUtilization(recipient, newRecipientLoad)) {
                    recipient.increaseLoad(loadToDecrease);
                    remainingToOptimize = remainingToOptimize - loadToDecrease;
                    break;
                }
            }
            server.decreaseLoad(loadToDecrease);
        }
        if (remainingToOptimize > 0) {
            if (remainingToOptimize <= DEFAULT_MAX_LOAD) {
                dataCenter.addServerWithLoadAndTurnOn(remainingToOptimize);
            } else {
                dataCenter.addServerWithCustomMaxLoadWithLoadAndTurnOn(remainingToOptimize); // or to some default servers
            }
        }
    }

    private boolean isAllowedUtilization(Server server, double load) {
        var newUtilization = server.calculateUtilizationWithNewLoad(load);
        return newUtilization >= LEFT && newUtilization < RIGHT;
    }
}
