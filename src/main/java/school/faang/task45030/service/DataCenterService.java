package school.faang.task45030.service;

import school.faang.task45030.model.DataCenter;
import school.faang.task45030.model.ResourceRequest;
import school.faang.task45030.model.Server;
import school.faang.task45030.model.Strategy;
import school.faang.task45030.strategy.EnergyEfficiencyOptimizationStrategy;
import school.faang.task45030.strategy.LoadBalanceOptimizationStrategy;
import school.faang.task45030.strategy.OptimizationStrategy;

public class DataCenterService {

    private final DataCenter dataCenter = new DataCenter();
    private OptimizationStrategy strategy;

    public void setStrategy(Strategy strategyName) {
        if (strategyName == Strategy.ByLoad) {
            strategy = new LoadBalanceOptimizationStrategy();
        } else {
            strategy = new EnergyEfficiencyOptimizationStrategy();
        }
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        double energyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            energyConsumption += server.getEnergyConsumption();
        }
        return energyConsumption;
    }

    public boolean allocateResources(ResourceRequest request) {
        double requestedLoad = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (availableLoad > 0) {
                double utilizedLoad = Math.min(requestedLoad, availableLoad);
                requestedLoad -= utilizedLoad;
                server.setLoad(server.getLoad() + utilizedLoad);
            }
            if (requestedLoad <= 0) {
                return true;
            }
        }
        return false;
    }

    public void releaseResources(ResourceRequest request) {
        double loadToRelease = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double loadReduction = Math.min(server.getLoad(), loadToRelease);
            loadToRelease -= loadReduction;
            server.setLoad(server.getLoad() - loadReduction);
            if (loadToRelease <= 0) {
                break;
            }
        }
    }

    public void optimize() {
        strategy.optimize(dataCenter);
    }

}
