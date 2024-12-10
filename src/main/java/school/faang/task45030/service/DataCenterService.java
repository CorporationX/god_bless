package school.faang.task45030.service;

import school.faang.task45030.model.DataCenter;
import school.faang.task45030.model.ResourceRequest;
import school.faang.task45030.model.Server;
import school.faang.task45030.strategy.EnergyEfficiencyOptimizationStrategy;
import school.faang.task45030.strategy.LoadBalanceOptimizationStrategy;
import school.faang.task45030.strategy.OptimizationStrategy;

public class DataCenterService {

    DataCenter dataCenter = new DataCenter();
    private OptimizationStrategy strategy;

    public void addServer(Server server) {
        dataCenter.getServerList().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServerList().remove(server);
    }

    public double getTotalEnergyConsumption() {
        double energyConsumption = 0;
        for (Server server : dataCenter.getServerList()) {
            energyConsumption += server.getEnergyConsumption();
        }
        return energyConsumption;
    }

    public boolean allocateResources(ResourceRequest request) {
        double requestedLoad = request.getLoad();
        for (Server server : dataCenter.getServerList()) {
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
        for (Server server : dataCenter.getServerList()) {
            double loadReduction = Math.min(server.getLoad(), loadToRelease);
            loadToRelease -= loadReduction;
            server.setLoad(server.getLoad() - loadReduction);
            if (loadToRelease <= 0) {
                break;
            }
        }
    }

    public void optimizeByLoad() {
        strategy = new LoadBalanceOptimizationStrategy();
        strategy.optimize(dataCenter);
    }

    public void optimizeByEnergy() {
        strategy = new EnergyEfficiencyOptimizationStrategy();
        strategy.optimize(dataCenter);
    }

}
