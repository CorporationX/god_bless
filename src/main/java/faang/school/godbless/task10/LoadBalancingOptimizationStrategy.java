package faang.school.godbless.task10;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double avgResourcesCount = dataCenter.getServers().stream()
                .map(Server::getEnergyConsumption).reduce(0d, Double::sum) / dataCenter.getServers().size();
        for (Server server : dataCenter.getServers()) {
            server.setEnergyConsumption(avgResourcesCount);
        }
    }
}
