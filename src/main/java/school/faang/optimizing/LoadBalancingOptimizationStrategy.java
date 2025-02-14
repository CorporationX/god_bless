package school.faang.optimizing;

import lombok.Data;

@Data
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0.0;
        for (Server server : dataCenter.getServers()) {
            totalLoad += server.getLoad();
        }

        double averageLoad = totalLoad / dataCenter.getServers().size();

        for (Server server : dataCenter.getServers()) {
            double newLoad = Math.min(averageLoad, server.getMaxLoad());
            server.setLoad(averageLoad);
            server.setEnergyConsumption(averageLoad * 0.5);
        }
    }
}
