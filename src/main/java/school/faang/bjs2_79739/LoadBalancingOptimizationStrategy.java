package school.faang.bjs2_79739;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = DataCenterService.getTotalEnergyConsumption(dataCenter);
        double loadPerServer = totalLoad / dataCenter.getServers().size();
        dataCenter.getServers().forEach(server -> {
            server.setLoad(loadPerServer);
        });
    }
}
