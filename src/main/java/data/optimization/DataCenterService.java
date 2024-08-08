package data.optimization;

import data.optimization.optim.strategy.OptimizationStrategy;
import data.optimization.optim.strategy.SillyOptimizationStrategy;
import lombok.Getter;
import lombok.NonNull;

public class DataCenterService {
    @Getter
    private static OptimizationStrategy optimizationStrategy = new SillyOptimizationStrategy();

    public static void addServer(@NonNull DataCenter dataCenter, @NonNull Server server) {
        if (dataCenter.getServerLoadsMap().containsKey(server)) {
            System.out.println("Server already added");
        } else {
            dataCenter.getServerLoadsMap().put(server, server.getMaxLoad());
        }
    }

    public static void removeServer(@NonNull DataCenter dataCenter, @NonNull Server server) {
        if (!dataCenter.getServerLoadsMap().containsKey(server)) {
            System.out.println("This data center doesn't have this server");
        } else {
            dataCenter.getServerLoadsMap().remove(server);
        }
    }

    public static double getTotalEnergyConsumption(@NonNull DataCenter dataCenter) {
        double consumption = 0;
        for (Server server : dataCenter.getServerLoadsMap().keySet()) {
            consumption += server.getEnergyConsumption();
        }

        return consumption;
    }

    public static void allocateResource(@NonNull DataCenter dataCenter, @NonNull ResourceRequest request) {
        for (Server server : dataCenter.getServerLoadsMap().keySet()) {
            if (server.getAvailableLoad() >= request.getLoad()) {
                server.addRequest(request);
                return;
            }
        }
        System.out.println("\nCan't allocate request, not enough available load in servers");
    }

    public static void releaseResource(@NonNull DataCenter dataCenter, @NonNull ResourceRequest request) {
        for (Server server : dataCenter.getServerLoadsMap().keySet()) {
            server.removeRequest(request);
        }
    }

    public static void setOptimizationStrategy(@NonNull OptimizationStrategy optimizationStrategy) {
        DataCenterService.optimizationStrategy = optimizationStrategy;
    }

    public static void optimize(@NonNull DataCenter dataCenter) {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        } else {
            System.out.println("\nOptimization strategy not selected");
            throw new NullPointerException("Optimization strategy not selected");
        }
    }
}
