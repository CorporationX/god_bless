package faang.school.godbless.BJS2_433.optimization;

import faang.school.godbless.BJS2_433.Server;
import faang.school.godbless.BJS2_433.DataCenter;

import java.util.List;
import java.util.NoSuchElementException;

public class PercentageServerLoadOptimizationStrategy implements OptimizationStrategy {
    private final double defCoefficient; //% how much to load each Server
    private final double additionalServerDefaultMaxLoad;

    public PercentageServerLoadOptimizationStrategy(double additionalServerDefaultMaxLoad, double defCoefficient) {
        this.additionalServerDefaultMaxLoad = additionalServerDefaultMaxLoad;
        this.defCoefficient = defCoefficient;
    }

    public PercentageServerLoadOptimizationStrategy() {
        this.additionalServerDefaultMaxLoad = 15;
        this.defCoefficient = 0.7;
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter.getServerList().isEmpty()) {
            throw new NoSuchElementException();
        }

        List<Server> servers = dataCenter.getServerList();

        double totalLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double totalMaxLoad = servers.stream().mapToDouble(Server::getMaxLoad).sum();
        double currentLoadPercent = totalLoad / totalMaxLoad;

        if (currentLoadPercent > defCoefficient) { //if servers loaded to much
            double needTotalMaxLoad = totalLoad / defCoefficient;
            int additionalServers = (int) ((Math.ceil(needTotalMaxLoad) - totalLoad) / additionalServerDefaultMaxLoad);

            for (int i = 0; i < additionalServers; i++) { //new servers for necessary additional load
                dataCenter.add(new Server(additionalServerDefaultMaxLoad));
            }

            double newTotalMaxLoad = totalMaxLoad + additionalServers * additionalServerDefaultMaxLoad;
            currentLoadPercent = totalLoad / newTotalMaxLoad;
            System.out.println("new load %: " + currentLoadPercent);
        }
        for (Server server : servers) {
            server.setLoad(server.getMaxLoad() * currentLoadPercent); //new load ratio for each server;
        }
    }
}