package school.faang.optimizingdc;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0;
        int serverCount = dataCenter.getServers().size();

        // Calculate total load
        for (Server server : dataCenter.getServers()) {
            totalLoad += server.getLoad();
        }

        // Evenly distribute the load across all servers
        double averageLoad = totalLoad / serverCount;

        for (Server server : dataCenter.getServers()) {
            server.setLoad(averageLoad);
        }

        System.out.println("Load balancing optimization complete.");
    }
}

