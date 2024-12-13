package school.faang.sprint_1.task_45040;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = dataCenter.getServers().stream()
                .mapToDouble(Server::getLoad)
                .sum();

        double averageLoad = totalLoad / dataCenter.getServers().size();

        dataCenter.getServers().forEach(server -> {
            if (server.getLoad() > averageLoad) {
                server.removeLoad(server.getLoad() - averageLoad);
            } else {
                server.addLoad(averageLoad - server.getLoad());
            }
        });
    }
}
