package BJS2_19551;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double medianLoad = dataCenter.getServersLoad(dataCenter) / dataCenter.getServers().size();
        System.out.println(medianLoad);
        for (Server server : dataCenter.getServers()) {
            if (server.getMaxLoad() > medianLoad) {
                server.setLoad(medianLoad);
                server.setEnergyConsumption(medianLoad / server.getMaxLoad());
            }
        }
    }
}
