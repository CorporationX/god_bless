package faang.school.godbless.BJS2_433;

import faang.school.godbless.BJS2_433.optimization.OptimizationStrategy;
import faang.school.godbless.BJS2_433.optimization.PercentageServerLoadOptimizationStrategy;
import lombok.Data;

import java.util.List;

@Data
public class DataCenterService {

    private final DataCenter dataCenter = DataCenter.getInstance();
    private final OptimizationStrategy strategy = new PercentageServerLoadOptimizationStrategy();
    private List<Server> servers = dataCenter.getServerList();

    public void addServer(Server server) {
        dataCenter.add(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServerList().stream()
                .mapToDouble(Server::getEnergyConsumption).sum();
    }

    public void optimizeEveryRequestedMinutes(int minutes) {
        strategy.optimize(this.dataCenter);
    }

    public boolean allocateResources(ResourceRequest request) {
        if (request.getLoad() > getTotalAvailableLoad()) {
            return false;
        }
        double requestLoad = request.getLoad();
        while (requestLoad != 0) {
            for (Server server : dataCenter.getServerList()) {
                double additionalLoad = Math.min(server.getMaxLoad() - server.getLoad(), requestLoad);
                server.setLoad(server.getLoad() + additionalLoad);
                requestLoad -= additionalLoad;
            }
        }
        return true;
    }

    public boolean releaseResources(ResourceRequest request) {
        double requestLoad = request.getLoad();
        while (requestLoad != 0) {
            for (Server server : dataCenter.getServerList()) {
                double additionalLoad = Math.min(server.getLoad(), requestLoad);
                server.setLoad(server.getLoad() - additionalLoad);
                requestLoad -= additionalLoad;
            }
        }
        return true;
    }

    private double getTotalAvailableLoad() {
        return dataCenter.getServerList().stream()
                .mapToDouble(server -> server.getMaxLoad() - server.getLoad())
                .sum();
    }
}