package school.faang.task_45020;

import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        servers.sort((s1, s2) -> (int) (s2.getLoad() - s1.getLoad()));

        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();

        for (Server server : servers) {
            if (totalLoad <= 0) {
                server.setLoad(0);
                System.out.println("Server turned off: " + server);
            } else {
                double availableCapacity = server.getMaxLoad();
                double loadToAssign = Math.min(totalLoad, availableCapacity);
                server.setLoad(loadToAssign);
                totalLoad -= loadToAssign;
            }
        }
    }

}
