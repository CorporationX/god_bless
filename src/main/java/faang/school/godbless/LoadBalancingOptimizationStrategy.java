package faang.school.godbless;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        double averageLoad = calculateAverageLoad(servers);

        redistributeExcessLoad(servers, averageLoad);
    }

    private double calculateAverageLoad(List<Server> servers) {
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        return totalLoad / servers.size();
    }

    private void redistributeExcessLoad(List<Server> servers, double averageLoad) {
        for (int i = 0; i < servers.size() - 1; i++) {
            Server fromServer = servers.get(i);
            double load = fromServer.getLoad();
            if (load > averageLoad) {
                double excessLoad = load - averageLoad;
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
}
