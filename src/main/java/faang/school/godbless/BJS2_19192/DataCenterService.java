package faang.school.godbless.BJS2_19192;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DataCenterService {
    private DataCenter dataCenter;
    LoadBalancingOptimizationStrategy loadBalancingOptimizationStrategy;
    EnergyEfficencyOptimizationStrategy energyEfficencyOptimizationStrategy;

    public void addServer(Server server) {
        dataCenter.serverList.add(server);
    }

    public void removeServerByParam(Server server) {
        dataCenter.serverList.remove(server);
    }

    public int getTotalEnergyConsumption() {
        int totalEnergy = 0;
        for(var server : dataCenter.getServerList()) {
            totalEnergy += server.getEnergyConsumption();
        }
        return totalEnergy;
    }

    public void allocateResources(ResourceRequest request) {
        while (request.getLoad() > 0) {
            for(var server : dataCenter.serverList) {
                if(server.getLoad() < server.getMaxLoad() && request.getLoad() > 0) {
                    server.setLoad(server.getLoad() + 1);
                    request.setLoad(request.getLoad() - 1);
                }
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        while (request.getLoad() > 0) {
            for(var server : dataCenter.serverList) {
                if(server.getLoad() > 0 && request.getLoad() > 0) {
                    server.setLoad(server.getLoad() - 1);
                    request.setLoad(request.getLoad() - 1);
                }
            }
        }
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
