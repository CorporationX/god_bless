package optimize_data_center_work;

import java.util.List;

public class LoadOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        double totalLoad = 0.0;
        double totalMaxLoad = 0.0;

        for (Server server : servers) {
            totalLoad += server.getLoad();
            totalMaxLoad += server.getMaxLoad();
        }

        double averageLoad = totalLoad / servers.size();
        double averageMaxLoad = totalMaxLoad / servers.size();

        for (Server server : servers) {
            if (server.getLoad() > averageLoad) {
                double excessLoad = server.getLoad() - averageLoad;
                double transferLoad = Math.min(excessLoad, averageMaxLoad - server.getLoad());
                server.setLoad(server.getLoad() - transferLoad);
            }
        }
    }
}

