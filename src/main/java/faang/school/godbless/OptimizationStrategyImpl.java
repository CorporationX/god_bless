package faang.school.godbless;

import java.util.List;

public class OptimizationStrategyImpl implements OptimizationStrategy {


    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        double totalLoad = 0;
        int serverCount = servers.size();

        for (Server server : servers) {
            totalLoad += server.getLoad();
        }

        double averageLoad = totalLoad / serverCount;

        for (Server server : servers) {
            double excessLoad = server.getLoad() - averageLoad;

            if (excessLoad > 0) {
                for (Server targetServer : servers) {
                    if (targetServer != server && targetServer.canAllocate(excessLoad)) {
                        server.release(excessLoad);
                        targetServer.allocate(excessLoad);
                        break;
                    }
                }
            }
        }

        System.out.println("Optimization complete. Servers are now more balanced.");
        printServerStatus(servers);
    }


    private void printServerStatus(List<Server> servers) {
        for (Server server : servers) {
            System.out.println("Server with max load " + server.getMaxLoad() +
                    " has current load " + server.getLoad() +
                    " and energy consumption " + server.getEnergyConsumption());
        }
    }
}