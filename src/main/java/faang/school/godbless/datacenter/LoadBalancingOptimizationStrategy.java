package faang.school.godbless.datacenter;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0;
        double totalMaxLoad = 0;
        for (Server server : dataCenter.getServerList()) {
            totalLoad += server.getLoad();
            totalMaxLoad += server.getMaxLoad();
        }
        double possibleAverage = totalLoad / totalMaxLoad;
        List<Server> overLoadedServers = new ArrayList<>();
        List<Server> underLoadedServers = new ArrayList<>();
        for (Server server : dataCenter.getServerList()) {
            double currentServerLoad = server.getLoad() / server.getMaxLoad();
            if (currentServerLoad < possibleAverage) {
                underLoadedServers.add(server);
            } else {
                overLoadedServers.add(server);
            }
        }
        for (Server server : overLoadedServers) {
            double toRelease = server.getLoad() - server.getMaxLoad() * possibleAverage;
            double toAdd = toRelease;
            for (Server underLoadedServer : underLoadedServers) {
                double averageForCurrentService = underLoadedServer.getMaxLoad() * possibleAverage;
                if (underLoadedServer.getLoad() + toRelease <= averageForCurrentService) {
                    underLoadedServer.setLoad(underLoadedServer.getLoad() + toAdd);
                    break;
                } else {
                    toAdd -= (possibleAverage - underLoadedServer.getLoad());
                    underLoadedServer.setLoad(possibleAverage * underLoadedServer.getMaxLoad());
                }
            }
            server.setLoad(server.getLoad() - toRelease);
        }
    }
}
