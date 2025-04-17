package school.faang.data_center.optimization_strategy;

import school.faang.data_center.model.DataCenter;
import school.faang.data_center.model.Server;

import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getAllServers();

        servers.sort((s1, s2) -> Double.compare(
                s2.getMaxLoad() - s2.getLoad(),
                s1.getMaxLoad() - s1.getLoad()
        ));

        double totalLoad = servers.stream()
                .mapToDouble(Server::getLoad).sum();

        for (Server s : servers) {
            if (totalLoad <= 0) {
                s.setLoad(0);
            } else {
                double allocated = Math.min(s.getMaxLoad(), totalLoad);
                s.setLoad(allocated);
                totalLoad -= allocated;
            }
        }
    }
}
