package school.faang.optimization;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        Collections.sort(servers, new Comparator<Server>() {
            @Override
            public int compare(Server s1, Server s2) {
                return Double.compare(s1.getEnergyConsumption(), s2.getEnergyConsumption());
            }
        });

        double totalLoad = 0;
        for (Server server : servers) {
            totalLoad += server.getLoad();
        }

        for (Server server : servers) {
            if (totalLoad <= 0) {
                server.setLoad(0);
            } else if (totalLoad <= server.getMaxLoad()) {
                server.setLoad(totalLoad);
                totalLoad = 0;
            } else {
                server.setLoad(server.getMaxLoad());
                totalLoad -= server.getMaxLoad();
            }
        }
    }
}
