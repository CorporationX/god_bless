package school.faang.data_center;

import java.util.Objects;

public class LoadBalancedOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        Objects.requireNonNull(dataCenter);

        double load = 0.0;
        double totalCapacity = 0.0;
        for (Server server : dataCenter.getServerList()) {
            load += server.getLoad();
            totalCapacity += server.getMaxLoad();
        }

        double remainingLoad = distributeLoadByPercentage(dataCenter, totalCapacity, load);

        distributeLoadLinearly(dataCenter, remainingLoad);
    }

    private double distributeLoadByPercentage(DataCenter dataCenter, double totalCapacity, double load) {
        double remainingLoad = load;
        for (Server server : dataCenter.getServerList()) {
            double share = server.getMaxLoad() / totalCapacity;
            double loadToAssign = load * share;
            if (loadToAssign > server.getMaxLoad()) {
                loadToAssign = server.getMaxLoad();
            }
            server.setLoad(loadToAssign);
            remainingLoad -= loadToAssign;
        }

        return remainingLoad;
    }

    private void distributeLoadLinearly(DataCenter dataCenter, double load) {
        for (Server server : dataCenter.getServerList()) {
            if (load <= 0) {
                return;
            }

            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (availableLoad <= 0.0) {
                continue;
            }

            double loadToAssign = Math.min(availableLoad, load);
            server.setLoad(server.getLoad() + loadToAssign);
            load -= loadToAssign;
        }

        if (load > 0.0) {
            System.out.println("The load could not be distributed: " + load);
        }
    }
}
