package school.faang.data.center.strategy.impl;

import school.faang.data.center.DataCenter;
import school.faang.data.center.OptimizationStrategy;
import school.faang.data.center.Server;

import java.util.List;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    public static final double BOUND_LOAD_INDEX = 0.4;
    public static final double MIN_POWER = 10;
    public static final double POWER_DELTA = 10;

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        for (Server server : servers) {
            if (server.getLoadIndex() < BOUND_LOAD_INDEX) {
                server.setEnergyConsumption(MIN_POWER);
            } else {
                server.setEnergyConsumption(server.getEnergyConsumption() + POWER_DELTA);
            }
        }
    }
}
