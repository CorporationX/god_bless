package school.faang.data_center;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {

        List<Server> sortedServers = new ArrayList<>(dataCenter.getServers());
        sortedServers.sort(Comparator.comparingDouble(Server::getMaxLoad).reversed());
        double totalLoad = dataCenter.getTotalLoad();

        for (Server server : sortedServers) {
            if (totalLoad == 0) {
                server.setLoad(0);
            }
            double loadToSet = Math.min(totalLoad, server.getMaxLoad());
            server.setLoad(loadToSet);
            totalLoad -= loadToSet;
        }
    }
}
