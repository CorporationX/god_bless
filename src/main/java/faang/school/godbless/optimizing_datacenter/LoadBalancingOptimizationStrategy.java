package faang.school.godbless.optimizing_datacenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

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

        int serverCount = 0;
        for (ResourceRequest request : pool) {
//            checks if load after adding request less than maxLoad
            if (servers.get(serverCount).getMaxLoad() < request.getLoad() + servers.get(serverCount).getLoad()) {
                serverCount = serverCount + 1 % servers.size();
            }
            servers.get(serverCount).executeRequest(request);
            dataCenter.getRequestMap().put(request, servers.get(serverCount));
            serverCount = (serverCount + 1) % servers.size();
        }
    }
}
