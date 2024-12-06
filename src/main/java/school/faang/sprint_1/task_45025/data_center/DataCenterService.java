package school.faang.sprint_1.task_45025.data_center;

import school.faang.sprint_1.task_45025.exceptions.LoadNotEnoughException;
import school.faang.sprint_1.task_45025.models.ResourceRequest;
import school.faang.sprint_1.task_45025.models.Server;
import school.faang.sprint_1.task_45025.optimization.OptimizationStrategy;

import java.util.List;

public class DataCenterService {
    private final DataCenter dataCenter = new DataCenter();

    public void addServer(Server server) {
        getServers().add(server);
    }

    public void removeServer(Server server) {
        getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (var server : getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public void allocateResources(ResourceRequest request) throws LoadNotEnoughException {
        double remainingLoad = request.getLoad();
        double availableLoad = getServers()
                .stream()
                .mapToDouble(server -> server.getMaxLoad() - server.getLoad())
                .sum();
        if (availableLoad < remainingLoad) {
            throw new LoadNotEnoughException(remainingLoad - availableLoad);
        }

        for (var server : getServers()) {
            double serverAvailableLoad = server.getMaxLoad() - server.getLoad();
            if (serverAvailableLoad > 0) {
                double loadToAllocate = Math.min(remainingLoad, serverAvailableLoad);
                remainingLoad -= loadToAllocate;
                server.setLoad(server.getLoad() + loadToAllocate);
                if (remainingLoad == 0) {
                    return;
                }
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        double remainingHoldLoad = request.getLoad();
        for (var server : getServers()) {
            double serverLoad = server.getLoad();
            if (serverLoad > 0) {
                double subtractiveLoad = Math.min(serverLoad, remainingHoldLoad);
                remainingHoldLoad -= subtractiveLoad;
                server.setLoad(serverLoad - subtractiveLoad);
                if (remainingHoldLoad == 0) {
                    break;
                }
            }
        }
    }

    public void optimize(OptimizationStrategy optimizationStrategy) {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        }
    }

    public List<Server> getServers() {
        return dataCenter.getServers();
    }
}
