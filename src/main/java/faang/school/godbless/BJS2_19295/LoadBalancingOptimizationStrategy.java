package faang.school.godbless.BJS2_19295;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    private DataCenterService dataCenterService;

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        double totalCurrentLoad = dataCenterService.calculateCurrentLoad(servers);
        double maxCapacity = dataCenterService.calculateMaxCapacity(servers);

        // Calculate ideal load that  each server should have
        double[] idealLoads = new double[servers.size()];
        for (int i = 0; i < servers.size(); i++) {
            idealLoads[i] = (servers.get(i).getMaxLoad() / maxCapacity) * totalCurrentLoad;
        }

        // Change server loads to match ideal loads
        for (int i = 0; i < servers.size(); i++) {
            Server server = servers.get(i);
            double currentLoad = server.getLoad();
            double idealLoad = idealLoads[i];

            if (currentLoad < idealLoad) {
                double additionalLoad = Math.min(idealLoad - currentLoad, server.getMaxLoad() - currentLoad);
                server.addLoad(additionalLoad);
            } else if (currentLoad > idealLoad) {
                double excessLoad = currentLoad - idealLoad;
                server.releaseLoad(excessLoad);
            }
        }
    }
}
