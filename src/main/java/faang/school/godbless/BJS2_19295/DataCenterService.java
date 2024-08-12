package faang.school.godbless.BJS2_19295;

import lombok.Getter;

import java.util.List;

@Getter
public class DataCenterService {

    private final OptimizationStrategy loadBalancingOptimization = new LoadBalancingOptimizationStrategy(this);
    private final OptimizationScheduler optimizationScheduler = new OptimizationScheduler();

    private DataCenter dataCenter;

    public DataCenterService() {
        dataCenter = DataCenter.getInstance();
    }


    protected void addServer(Server server) {
        dataCenter.addServer(server);
    }

    protected void deleteServer(Server server) {
        dataCenter.deleteServer(server);
    }

    protected double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    protected double calculateCurrentLoad(List<Server> servers) {
        double currentLoad = 0;
        for (Server server : servers) {
            currentLoad += server.getLoad();
        }
        return currentLoad;
    }

    protected double calculateAvailableLoad(List<Server> servers) {
        double availableLoad = 0;
        for (Server server : servers) {
            availableLoad += server.getMaxLoad() - server.getLoad();
        }
        return availableLoad;
    }

    protected double calculateMaxCapacity(List<Server> servers) {
        double maxCapacity = 0;
        for (Server server : servers) {
            maxCapacity += server.getMaxLoad();
        }
        return maxCapacity;
    }

    protected void scheduledOptimize(int timeDelayInSeconds) {
        optimizationScheduler.start(timeDelayInSeconds, this, loadBalancingOptimization);
    }

    protected void allocateResources(ResourceRequest request) {
        if (request.getLoad() <= 0) {
            throw new IllegalArgumentException("Load must be greater than zero");
        } else if (request.getLoad() > calculateAvailableLoad(dataCenter.getServers())) {
            throw new IllegalArgumentException("The load exceeds the maximum permissible load");
        }

        double remainingLoad = request.getLoad();

        for (Server server : dataCenter.getServers()) {
            if (remainingLoad <= 0) break;

            double availableCapacity = server.getMaxLoad() - server.getLoad();
            double loadToAdd = Math.min(remainingLoad, availableCapacity);
            dataCenter.addLoad(server, loadToAdd);
            remainingLoad -= loadToAdd;
        }
    }

    protected void releaseResources(ResourceRequest request) {
        if (request.getLoad() <= 0) {
            throw new IllegalArgumentException("Load must be greater than zero");
        } else if (request.getLoad() > calculateCurrentLoad(dataCenter.getServers())) {
            throw new IllegalArgumentException("The load exceeds the maximum releasable load");
        }

        double remainingReleasableLoad = request.getLoad();

        for (Server server : dataCenter.getServers()) {
            if (remainingReleasableLoad <= 0) break;

            double currentLoad = server.getLoad();
            double loadToRelease = Math.min(remainingReleasableLoad, currentLoad);
            dataCenter.releaseLoad(server, loadToRelease);
            remainingReleasableLoad -= loadToRelease;
        }
    }
}
