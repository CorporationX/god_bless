package faang.school.godbless.javahashmap.datacenter;

import java.util.List;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        float maxLoad = Server.MAX_LOAD;

        for (Server server : servers) {
            if (totalLoad <= maxLoad) {
                setLoad(server, totalLoad);
                totalLoad = 0;
            } else {
                setLoad(server, maxLoad);
                totalLoad -= maxLoad;
            }
        }
    }

    private void setLoad(Server server, double load) {
        server.releaseLoad(server.getLoad());
        server.handleLoad(load);
    }
}
