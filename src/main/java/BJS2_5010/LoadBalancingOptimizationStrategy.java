package BJS2_5010;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double loadServers = infoLoad(dataCenter, "getLoad");
        double maxLoadServers = infoLoad(dataCenter, "getMaxLoad");
        double divisionLoadOnServer = loadServers / maxLoadServers;
        for (Server server : dataCenter.getServers()) {
            server.setLoad(divisionLoadOnServer * server.getMaxLoad());
        }
    }

    private double infoLoad(DataCenter dataCenter, String method) {
        return switch (method) {
            case "getLoad" -> dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
            case "getMaxLoad" -> dataCenter.getServers().stream().mapToDouble(Server::getMaxLoad).sum();
            default -> 0;
        };
    }
}
