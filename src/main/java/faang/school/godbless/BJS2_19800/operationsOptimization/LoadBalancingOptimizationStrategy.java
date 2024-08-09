package faang.school.godbless.BJS2_19800.operationsOptimization;

import faang.school.godbless.BJS2_19800.model.DataCenter;
import faang.school.godbless.BJS2_19800.model.Server;
import lombok.Data;

import java.util.List;

@Data
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    private DataCenter dataCenter;

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServerList();
        double totalLoad = 0;
        for (Server server : servers) {
            totalLoad += server.getLoad();
        }
        double avgLoad = totalLoad / servers.size();
        for (Server server : servers) {
            server.setLoad(avgLoad);
        }
    }
}
