package faang.school.godbless.datacenter;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy{

    public void optimize(DataCenter dataCenter) {
        List<Server> overloadedServers = new ArrayList<>();
        List<Server> underloadedServers = new ArrayList<>();
        double sum = 0;
        for (var server : dataCenter.getServers()) {
            sum += server.getLoad();
        }
        double averageLoad = sum / dataCenter.getServers().size();
        for (var server : dataCenter.getServers()) {
            if (server.getLoad() > averageLoad) {
                overloadedServers.add(server);
            }
            else if (server.getLoad() < averageLoad) {
                underloadedServers.add(server);
            }
        }
        while (!overloadedServers.isEmpty() && !underloadedServers.isEmpty()) {
            Server overloadedServer = overloadedServers.get(overloadedServers.size() - 1);
            double totalLoadToShare = overloadedServer.getLoad() - averageLoad;
            double loadToShare = totalLoadToShare / underloadedServers.size();
            List<Server> readyToDeleteOverloadedServers = new ArrayList<>();
            List<Server> readyToDeleteUnderloadedServers = new ArrayList<>();
            for (var underloadedServer : underloadedServers) {
                double excess = shareLoad(underloadedServer, loadToShare);
                overloadedServer.setLoad((overloadedServer.getLoad() - loadToShare) + excess);
                readyToDeleteOverloadedServers.add(overloadedServer);
                if (underloadedServer.getLoad() >= averageLoad) {
                    readyToDeleteUnderloadedServers.add(underloadedServer);
                }
            }
            overloadedServers.removeAll(readyToDeleteOverloadedServers);
            underloadedServers.removeAll(readyToDeleteUnderloadedServers);
        }
    }

    private double shareLoad(Server server, double load) {
        double totalLoad = server.getLoad() + load;
        if (server.getMaxLoad() < totalLoad) {
            server.setLoad(server.getMaxLoad());
            return totalLoad - server.getMaxLoad();
        }
        server.setLoad(totalLoad);
        return 0.0;
    }
}
