package ru.kraiush.BJS219602;

import java.util.List;

public interface OptimizationStrategy {
    void optimize(DataServers dataCenter, List<Integer> listOverload);
}
