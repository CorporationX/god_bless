package faang.school.godbless.optimizing_the_work_of_the_data_center.strategy;

import faang.school.godbless.optimizing_the_work_of_the_data_center.interfaces.OptimizationStrategy;
import faang.school.godbless.optimizing_the_work_of_the_data_center.main.DataCenter;
import faang.school.godbless.optimizing_the_work_of_the_data_center.main.Server;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0;
        for (Server server : dataCenter.getServers()) {
            totalLoad += server.getLoad();
        }
        double averageLoad = totalLoad / dataCenter.getServers().size();
        for (Server server : dataCenter.getServers()) {
            server.setLoad(averageLoad);
        }
    }
}
