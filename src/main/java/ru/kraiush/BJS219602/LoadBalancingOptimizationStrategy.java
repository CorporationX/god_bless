package ru.kraiush.BJS219602;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    DataServers dataCenter;
    List<Integer> listOverload;

    public LoadBalancingOptimizationStrategy(DataServers dataCenter, List<Integer> listOverload) {
        this.dataCenter = dataCenter;
        this.listOverload = listOverload;
    }

    @Override
    public void optimize(DataServers dataCenter, List<Integer> listOverload) {

        List<Server> servers = dataCenter.getServers();

        for (int i = 0; i < servers.size(); i++) {
            if (listOverload.get(i) != 0) {
                servers.get(i).setMaxLoad(servers.get(i).getMaxLoad() * 2);
            }
        }
    }
}
