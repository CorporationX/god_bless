package optimizingdatacenter;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = dataCenter.getServers().stream()
                .mapToDouble(Server::getLoad)
                .sum();

        double averageLoad = totalLoad / dataCenter.getServers().size();

        dataCenter.getServers()
                .forEach(s -> s.setLoad(averageLoad));
    }
}
