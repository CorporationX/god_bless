package school.faang.bjs2_69892;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> sortedServers = new ArrayList<>(dataCenter.getServers());
        sortedServers.sort(Comparator.comparingDouble(Server::getMaxLoad));
        double totalLoad = dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
        int countServers = dataCenter.getServers().size();
        double avgLoad = totalLoad / countServers;
        for (Server server : dataCenter.getServers()) {
            if (server.getMaxLoad() > avgLoad) {
                server.setLoad(server.getMaxLoad());
                totalLoad -= server.getMaxLoad();
                countServers--;
                avgLoad = totalLoad / countServers;
            } else {
                server.setLoad(avgLoad);
            }
        }
    }
}
