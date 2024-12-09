package school.faang.bjs245028.balancer;

import school.faang.bjs245028.model.DataCenter;
import school.faang.bjs245028.model.Server;

import java.util.Comparator;
import java.util.List;


public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        servers.sort(Comparator.comparingDouble(Server::getEnergyConsumption));

        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();

        for (Server server : servers) {
            if (totalLoad <= 0) {
                server.setLoad(0);
                System.out.println("Сервер выключен: " + server);
            } else {
                double availableCapacity = server.getMaxLoad();
                double loadToAssign = Math.min(totalLoad, availableCapacity);
                server.setLoad(loadToAssign);
                totalLoad -= loadToAssign;
            }
        }
    }
}