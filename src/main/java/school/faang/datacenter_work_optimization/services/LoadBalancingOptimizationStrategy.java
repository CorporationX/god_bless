package school.faang.datacenter_work_optimization.services;

import school.faang.datacenter_work_optimization.model.DataCenter;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalMaxLoad = dataCenter.getServers()
                .stream().mapToDouble(server -> server.getMaxLoad())
                .sum();

        double totalOccupancy = dataCenter.calculateTotalLoad() / totalMaxLoad;

        dataCenter.getServers().forEach(server -> {
            server.setLoad(totalOccupancy * dataCenter.calculateTotalLoad());
        });
    }
}
