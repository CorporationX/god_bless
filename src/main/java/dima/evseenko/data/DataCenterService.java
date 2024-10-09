package dima.evseenko.data;

import dima.evseenko.data.strategy.EnergyEfficiencyOptimizationStrategy;
import dima.evseenko.data.strategy.LoadBalancingOptimizationStrategy;
import dima.evseenko.data.strategy.OptimizationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DataCenterService {
    private final DataCenter dataCenter = new DataCenter();
    private final Map<OptimizationStrategy.Strategy, OptimizationStrategy> optimizationStrategies = new HashMap<>();

    public DataCenterService() {
        scheduleOptimize();
    }

    public void addServer(Server server) {
        if (Objects.nonNull(server)) {
            dataCenter.getServers().add(server);
        }
    }

    public void addServers(List<Server> servers) {
        if (Objects.nonNull(servers)) {
            servers.forEach(this::addServer);
        }
    }

    public void deleteServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public boolean allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() + request.getLoad() < server.getMaxLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
                return true;
            }
        }
        return false;
    }

    public boolean releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() >= request.getLoad()) {
                server.setLoad(server.getLoad() - request.getLoad());
                return true;
            }
        }
        return false;
    }

    private void scheduleOptimize() {
        Executors.newSingleThreadExecutor().submit(() -> {
            while (true) {
                TimeUnit.MINUTES.sleep(30);
                optimize();
            }
        });
    }

    public void addOptimizationStrategy(OptimizationStrategy.Strategy strategy) {
        if (Objects.nonNull(strategy)) {
            optimizationStrategies.put(strategy,
                    switch (strategy) {
                        case LOAD_BALANCING -> new LoadBalancingOptimizationStrategy();
                        case ENERGY_EFFICIENCY -> new EnergyEfficiencyOptimizationStrategy();
                    }
            );
        }
    }

    public void removeOptimizationStrategy(OptimizationStrategy.Strategy strategy) {
        if (Objects.nonNull(strategy)) {
            optimizationStrategies.remove(strategy);
        }
    }

    public void optimize() {
        optimizationStrategies.forEach((strategy, optimizationStrategy) -> optimizationStrategy.optimize(dataCenter));
    }

    public List<Server> getServers() {
        return dataCenter.getServers();
    }

    public void printServers() {
        dataCenter.getServers().forEach(System.out::println);
        System.out.println();
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }
}
