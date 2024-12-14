package faang.school.godbless.optimizing_datacenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        List<ResourceRequest> pool = new ArrayList<>(servers.size());
//        release all requests and store them in array for later balancing
        for (Map.Entry<ResourceRequest, Server> entry : dataCenter.getRequestMap().entrySet()) {
            pool.add(entry.getKey());
            entry.getValue().releaseRequest(entry.getKey());
        }
        dataCenter.getRequestMap().clear();

//        greedy approach, assuming least energy increase when allocating request to server leads to more efficient request distribution
        for (ResourceRequest request : pool) {
            double leastEnergyIncrease = 999999999;
            Server bestServer = null;
            for (Server server : servers) {
                if (server.getMaxLoad() >= (server.getLoad() + request.getLoad()) && Math.pow(2, server.getLoad() + request.getLoad()) < leastEnergyIncrease) {
                    leastEnergyIncrease = Math.pow(2, server.getLoad() + request.getLoad());
                    bestServer = server;
                }
            }
            assert bestServer != null;
            bestServer.executeRequest(request);
            dataCenter.getRequestMap().put(request, bestServer);
        }
    }
}
