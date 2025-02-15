package school.faang.optimizing;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0.0;
        for (Server server : dataCenter.getServers()) {
            totalLoad += server.getLoad();
        }

        double averageLoad = totalLoad / dataCenter.getServers().size();

        for (Server server : dataCenter.getServers()) {
            if (averageLoad > server.getMaxLoad()) {
                server.setLoad(server.getMaxLoad());
            } else {
                server.setLoad(averageLoad);
            }
            server.setEnergyConsumption(averageLoad * 0.5);
        }
    }
}
