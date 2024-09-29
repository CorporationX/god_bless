package ru.kraiush.BJS219602;

import java.util.List;

public class Optimize {

    DataServers dataCenter;
    List<Integer> listOverload;

    public Optimize(DataServers dataCenter, List<Integer> listOverload) {
        this.dataCenter = dataCenter;
        this.listOverload = listOverload;
    }

    public void optimyzeMethod(OptimizationStrategy method) {
        method.optimize(dataCenter, listOverload);
    }
}
