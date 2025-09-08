package school.faang.bjs2__86088;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter, double load) {
        double totalLoad = dataCenter.getListServer()
                .stream()
                .mapToDouble(d -> d.getLoad())
                .sum();

        int countServer = dataCenter.getListServer().size();
        double loadOneServer = totalLoad / countServer;

        dataCenter.getListServer().forEach(d -> d.setLoad(loadOneServer));
    }
}
