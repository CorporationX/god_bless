package faang.school.godbless.BJS2_19251;

import java.util.Collections;
import java.util.Comparator;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy{
    //Это, конечно, сложно назвать балансировщиком нагрузки, но хоть что-то)
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalMaxLoad = dataCenter.getServers().stream().mapToDouble(Server::getMaxLoad).sum();
        double totalCurrentLoad = dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
        dataCenter.getServers().sort((a, b) -> Double.compare(a.getLoad(), b.getLoad()));
        double balancedLoad = totalCurrentLoad / dataCenter.getServers().size();
        for (Server server: dataCenter.getServers()){
            server.setLoad(balancedLoad);

            if(server.getLoad() > server.getMaxLoad()){
                server.setLoad(server.getMaxLoad());
                balancedLoad = balancedLoad + (balancedLoad - server.getMaxLoad());
            }
        }
    }
}
