package faang.school.godbless.data_center;

import lombok.Getter;

import java.util.Comparator;

@Getter
public enum OptimizationStrategy {
    LOAD_BALANCING_OPTIMIZATION_STRATEGY((server1, server2) -> {
        if (server1.getLoad() != server2.getLoad()) {
            return (int) (server1.getLoad() - server2.getLoad());
        } else {
            return (int) (server1.getMaxLoad() - server2.getMaxLoad());
        }
    }),
    ENERGY_EFFICIENCY_OPTIMIZATION_STRATEGY((server1, server2) -> {
        if (server1.getLoad() != server2.getLoad()) {
            return (int) (server2.getLoad() - server1.getLoad());
        } else {
            return (int) (server2.getMaxLoad() - server1.getMaxLoad());
        }
    });

    final Comparator<Server> compareStrategy;

    OptimizationStrategy(Comparator<Server> compareStrategy) {
        this.compareStrategy = compareStrategy;
    }

}
