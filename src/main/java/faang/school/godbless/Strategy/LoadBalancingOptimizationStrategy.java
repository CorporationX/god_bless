package faang.school.godbless.Strategy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    private List<Server> servers;
    private double averageLoad;

    @Override
    public void optimize(DataCenter dataCenter) {
        servers = dataCenter.getServers();
        double totalLoad = dataCenter.getTotalLoad();
        averageLoad = totalLoad / servers.size();
        Set<Server> serversToReduceLoad = new HashSet<>();
        Set<Server> serversToIncreaseLoad = new HashSet<>();

        for (Server server : servers) {
            double difference = server.getLoad() - averageLoad;
            if (difference > 0) {
                serversToReduceLoad.add(server);
            } else if (difference < 0) {
                serversToIncreaseLoad.add(server);
            }
        }

        loadTransfer(serversToReduceLoad, serversToIncreaseLoad);
    }

    private void loadTransfer(Set<Server> serversToReduceLoad, Set<Server> serversToIncreaseLoad) {
        Iterator<Server> reduceIterator = serversToReduceLoad.iterator();
        Iterator<Server> increaseIterator = serversToIncreaseLoad.iterator();

        while (reduceIterator.hasNext() && increaseIterator.hasNext()) {
            Server reduceServer = reduceIterator.next();
            Server increaseServer = increaseIterator.next();

            double excessLoad = reduceServer.getLoad() - averageLoad;
            double neededLoad = averageLoad - increaseServer.getLoad();
            double transferLoad = Math.min(excessLoad, neededLoad);

            reduceServer.setLoad(reduceServer.getLoad() - transferLoad);
            increaseServer.setLoad(increaseServer.getLoad() + transferLoad);
            if (reduceServer.getLoad() <= averageLoad) {
                reduceIterator.remove();
            }
            if (increaseServer.getLoad() >= averageLoad) {
                increaseIterator.remove();
            }
        }

        System.out.println("Load balancing optimization complete.");
    }
}