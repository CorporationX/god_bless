package faang.school.godbless.beksultan2005;

import lombok.Getter;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

@Getter
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        Map<Double, ResourceRequest> sortResourceRequests = new TreeMap<>(Comparator.reverseOrder());
        Map<Double, Server> sortServers = new TreeMap<>(Comparator.reverseOrder());

        for (Server server : dataCenter.getServers()){
            sortServers.put(server.getMaxLoad(), server);
            server.
        }

        for (ResourceRequest resourceRequest : dataCenter.getResourceRequests().keySet()){
            sortResourceRequests.put(resourceRequest.getLoad(), resourceRequest);
        }


        for (ResourceRequest resourceRequest : sortResourceRequests.values()){
            for (Server server : dataCenter.getServers()){
                if (server.canAllocate(resourceRequest.getLoad())) {
                    server.allocateLoad(resourceRequest.getLoad());
                    break;
                }
            }
        }

    }
}
