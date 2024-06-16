package faang.school.godbless.BJS28666;

import java.util.List;

public class AverageLoadOptimizationStrategy implements OptimizationStrategy{
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double averageLoad = dataCenter.getTotalLoad() / dataCenter.getTotalMaxLoad();

        for (Server server : servers) {
            server.setLoad(server.getMaxLoad() * averageLoad);
        }
    }
}
