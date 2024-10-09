package dima.evseenko.data.strategy;

import dima.evseenko.data.DataCenter;

public interface OptimizationStrategy {
    void optimize(DataCenter dataCenter);

    enum Strategy {
        LOAD_BALANCING, ENERGY_EFFICIENCY
    }
}
