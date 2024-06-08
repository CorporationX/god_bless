package faang.school.godbless.dataCenter;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy{
    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter != null) {
            List<Server> servers = dataCenter.getServers();

            double summaryLoad = servers.stream()
                    .mapToDouble(Server::getLoad)
                    .sum();

            double averageLoad = summaryLoad / servers.size();
            double lessAverageLoad;
            double biggerAverageLoad;

            for (Server lessAverageLoadServer : servers) {
                if (lessAverageLoadServer.getLoad() < averageLoad) {
                    lessAverageLoad = averageLoad - lessAverageLoadServer.getLoad();
                    for (Server biggerAverageLoadServer : servers) {
                        if (biggerAverageLoadServer.getLoad() > averageLoad) {
                            biggerAverageLoad = biggerAverageLoadServer.getLoad() - averageLoad;
                            double min = Double.min(lessAverageLoad, biggerAverageLoad);

                            lessAverageLoadServer.setLoad(lessAverageLoadServer.getLoad() + min);
                            lessAverageLoadServer.setEnergyConsumption(lessAverageLoadServer.getEnergyConsumption() + min);

                            biggerAverageLoadServer.setLoad(biggerAverageLoadServer.getLoad() - min);
                            biggerAverageLoadServer.setEnergyConsumption(biggerAverageLoadServer.getEnergyConsumption() - min);

                            if (min == lessAverageLoad) {
                                break;
                            }

                            lessAverageLoad -= biggerAverageLoad;
                        }
                    }
                }
            }
        }
    }
}
