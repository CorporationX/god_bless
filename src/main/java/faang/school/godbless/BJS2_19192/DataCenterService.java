package faang.school.godbless.BJS2_19192;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;
    private LoadBalancingOptimizationStrategy loadBalancingOptimizationStrategy;
    private EnergyEfficencyOptimizationStrategy energyEfficencyOptimizationStrategy;

    public void addServer(Server server) {
        dataCenter.getServerList().add(server);
    }

    public void removeServerByParam(Server server) {
        dataCenter.getServerList().remove(server);
    }

    public int getTotalEnergyConsumption() {
        int totalEnergy = 0;
        for(var server : dataCenter.getServerList()) {
            totalEnergy += server.getEnergyConsumption();
        }
        return totalEnergy;
    }

    public void allocateResources(ResourceRequest request) {
        double requiredLoad = request.getLoad();

        for (var server : dataCenter.getServerList()) {
            double availableCapacity = server.getMaxLoad() - server.getLoad();
            double loadToAllocate = Math.min(availableCapacity, requiredLoad);

            server.setLoad(server.getLoad() + loadToAllocate);
            requiredLoad -= loadToAllocate;

            if (requiredLoad == 0) {
                break;
            }
        }

        request.setLoad(requiredLoad);
    }

    public void releaseResources(ResourceRequest request) {
        double loadToRelease = request.getLoad();

        for (var server : dataCenter.getServerList()) {
            double loadOnServer = server.getLoad();
            double loadToRemove = Math.min(loadOnServer, loadToRelease);

            server.setLoad(server.getLoad() - loadToRemove);
            loadToRelease -= loadToRemove;

            if (loadToRelease == 0) {
                break;
            }
        }

        request.setLoad(loadToRelease);
    }


    public void optimize() {
        if(dataCenter.coefficientOfLoadDistribution() < 0.5) {
            loadBalancingOptimizationStrategy.optimize(dataCenter);
        }
        if(dataCenter.coefficientOfEnergyDistribution() < 0.5) {
            energyEfficencyOptimizationStrategy.optimize(dataCenter);
        }
    }
}
