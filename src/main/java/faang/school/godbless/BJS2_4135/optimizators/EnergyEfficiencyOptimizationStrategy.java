package faang.school.godbless.BJS2_4135.optimizators;

import faang.school.godbless.BJS2_4135.models.DataCenter;
import faang.school.godbless.BJS2_4135.models.Server;

import java.util.Comparator;
import java.util.List;

// Пока не смог решить вопрос с максимальным перераспределнием загрузки, учитывая и energyConsumption, и maxLoad;
public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        Comparator<Server> efficiencyComparator = Comparator.comparingDouble(server -> server.getLoad() / server.getEnergyConsumption());
        servers.sort(efficiencyComparator.reversed());

        for (Server server : servers) {
            double serverMaxLoad = server.getMaxLoad();
            double serverCurrentLoad = server.getLoad();

            if (serverCurrentLoad < serverMaxLoad) {
                double remainingLoad = Math.min(totalLoad, serverMaxLoad - serverCurrentLoad);
                server.allocate(remainingLoad);
                totalLoad -= remainingLoad;
            }

            if (totalLoad <= 0 || totalLoad > serverMaxLoad) {
                break;
            }
        }
    }
}
