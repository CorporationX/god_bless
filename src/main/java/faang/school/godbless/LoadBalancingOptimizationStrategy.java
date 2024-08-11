package faang.school.godbless;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter == null) {
            return;
        }

        List<Server> servers = dataCenter.getServers();

        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double totalMaxLoad = servers.stream().mapToDouble(Server::getMaxLoad).sum();
        double optimumLoadPercent = totalLoad / totalMaxLoad;

        redistributeLoad(servers, optimumLoadPercent);
    }

    private void redistributeLoad(List<Server> servers, double optimumLoadPercent) {
        for (int i = 0; i < servers.size() - 1; i++) {
            Server fromServer = servers.get(i);
            double optimumLoad = fromServer.getMaxLoad() * optimumLoadPercent;
            double excessLoad = fromServer.getLoad() - optimumLoad;

            for (int j = i + 1; j < servers.size(); j++) {
                Server targetServer = servers.get(j);
                if (targetServer.canHandleLoad(excessLoad)) {
                    fromServer.releaseLoad(excessLoad);
                    targetServer.allocateLoad(excessLoad);
                    break;
                }
            }
        }
    }
}
