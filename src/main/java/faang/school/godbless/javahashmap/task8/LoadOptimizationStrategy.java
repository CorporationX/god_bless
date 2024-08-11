package faang.school.godbless.javahashmap.task8;

import java.util.*;

public class LoadOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double averageLoad = 0;
        for (Server server : servers) {
            averageLoad += server.getLoad();
        }
        averageLoad /= servers.size();
        servers.sort(Comparator.comparingDouble(Server::getLoad));
        int indexEnd = servers.size() - 1;
        for (int indexStart = 0; indexStart < indexEnd; indexStart++) {
            double delta = servers.get(indexEnd).getLoad() - averageLoad;
            if (delta > 0) {
                servers.get(indexStart).setLoad(servers.get(indexStart).getLoad() + delta);
                servers.get(indexEnd).setLoad(servers.get(indexEnd).getLoad() - delta);
            }
        }
    }
}
