package school.faang.task1310;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0.0;
        for (Server server : dataCenter.getAllServers()) {
            totalLoad += server.getLoad();
        }

        double avgLoad = totalLoad / dataCenter.getAllServers().size();
        for (Server server : dataCenter.getAllServers()) {
            if (server.getLoad() > avgLoad) {
                for (Server anotherServer : dataCenter.getAllServers()) {
                    if (anotherServer.getLoad() < avgLoad) {
                        double excess = server.getLoad() - avgLoad;
                        double freeSpace = avgLoad - anotherServer.getLoad();
                        double difference = Math.min(excess, freeSpace);
                        server.setLoad(server.getLoad() - difference);
                        anotherServer.setLoad(anotherServer.getLoad() + difference);
                        excess -= difference;
                        if (excess <= 0.0) {
                            break;
                        }
                    }
                }
            }
        }
    }
}
