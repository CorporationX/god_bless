package derschrank.sprint01.task12.bjstwo_45017;

import derschrank.sprint01.task12.bjstwo_45017.optimization.LoadBalancingOptimizationStrategy;
import derschrank.sprint01.task12.bjstwo_45017.optimization.OptimizationStrategy;
import derschrank.sprint01.task12.bjstwo_45017.servers.Server;

public class DataCenterService {
    private static final OptimizationStrategy DEFAULT_STRATEGY = new LoadBalancingOptimizationStrategy();
    private OptimizationStrategy optimizationStrategy;
    private DataCenter dataCenter;

    public DataCenterService() {
        this(DEFAULT_STRATEGY);
    }

    public DataCenterService(OptimizationStrategy strategy) {
        this(new DataCenter(), strategy);
    }

    public DataCenterService(DataCenter dataCenter, OptimizationStrategy strategy) {
        this.optimizationStrategy = strategy;
        this.dataCenter = dataCenter;
    }

    public void setOptimizationStrategy(OptimizationStrategy strategy) {
        this.optimizationStrategy = strategy;
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }


    public double getTotalEnergyConsumption() {
        return dataCenter.getTotalEnergyConsumption();
    }

    public double getTotalAvailableLoad() {
        return dataCenter.getTotalAvailableLoad();
    }

    public void allocateResources(ResourceRequest request) {
        double moreNeedResource = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (moreNeedResource == 0) {
                break;
            }

            if (!server.isOn()) {
                server.switchOn();
            }

            double resourcesFromThisServer = Math.min(server.getAvailableLoad(), moreNeedResource);
            if (server.allocateLoad(resourcesFromThisServer)) {
                moreNeedResource -= resourcesFromThisServer;
            }
        }
        if (moreNeedResource > 0) {
            System.out.println("We don't have resources for this Request");
            releaseResources(new ResourceRequest(request.getLoad() - moreNeedResource));
        }
    }

    public void releaseResources(ResourceRequest request) {
        double moreNeedResourceToRelease = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (moreNeedResourceToRelease == 0) {
                break;
            }

            if (!server.isOn()) {
                continue;
            }

            double resourcesFromThisServer = Math.min(server.getLoad(), moreNeedResourceToRelease);
            if (server.releaseLoad(resourcesFromThisServer)) {
                moreNeedResourceToRelease -= resourcesFromThisServer;
            }
        }
    }

    public void optimize() {
        optimizationStrategy.optimize(dataCenter);
    }

    public void resetAllServers() {
        dataCenter.resetAllServers();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(dataCenter.toString());

        result.append("\nOptimizationStrategy: ");
        result.append(optimizationStrategy);
        result.append("\n");

        return result.toString();
    }
}
