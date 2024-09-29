package ru.kraiush.BJS219602;

import java.util.List;

class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {

    DataServers dataCenter;
    List<Integer> listOverload;

    public EnergyEfficencyOptimizationStrategy(DataServers dataCenter, List<Integer> listOverload) {
        this.dataCenter = dataCenter;
        this.listOverload = listOverload;
    }

    @Override
    public void optimize(DataServers dataCenter, List<Integer> listOverload) {

        List<Server> servers = dataCenter.getServers();

        for (int i = 0; i < servers.size(); i++) {
            if (listOverload.get(i) != 0) {
                servers.get(i).setEnergyConsumption(servers.get(i).getEnergyConsumption() * 2);
            }
        }
    }

}
