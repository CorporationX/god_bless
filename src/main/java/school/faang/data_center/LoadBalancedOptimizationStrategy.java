package school.faang.data_center;

public class LoadBalancedOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0;
        for (Server server : dataCenter.getServerList()) {
            totalLoad += server.getLoad();
        }

        int serverCount = dataCenter.getServerList().size();

        for (Server server : dataCenter.getServerList()) {
            double averageLoad = totalLoad / serverCount;
            double loadToAllocate = averageLoad;
            if (averageLoad > server.getMaxLoad()) {
                loadToAllocate = server.getMaxLoad();
            }

            server.setLoad(loadToAllocate);
            totalLoad -= loadToAllocate;
            serverCount--;
        }
    }
}
