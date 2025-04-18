package school.faang.bjs2_68695;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    private final DataCenterService dataCenterService = new DataCenterService();

    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0.0;
        for (Server server : dataCenter.servers()) {
            totalLoad += server.getLoad();
        }
        double averageLoad = totalLoad / dataCenter.servers().size();
        for (Server server : dataCenter.servers()) {
            server.setLoad(averageLoad);
        }
    }
}
