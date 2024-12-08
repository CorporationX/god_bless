package school.faang.task_45026.service;

import lombok.Getter;
import lombok.Setter;
import school.faang.task_45026.entity.ResourceRequest;
import school.faang.task_45026.repository.DataCenter;
import school.faang.task_45026.entity.Server;
import school.faang.task_45026.strategy.OptimizationStrategy;

import java.util.List;

@Setter
@Getter
public class DataCenterService {
    private final DataCenter dataCenter = new DataCenter();
    private OptimizationStrategy optimizationStrategy;

    public void addServer(Server server) {
        if (server == null) {
            throw new IllegalArgumentException("server is null");
        }
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        if (server == null) {
            throw new IllegalArgumentException("server is null");
        }
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption() {
        List<Server> servers = dataCenter.getServers();

        return servers.stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }


    /**
     * @param request an argument.
     * @return amount of unAllocated resources
     */
    public double allocateResources(ResourceRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("request is null");
        }

        List<Server> servers = dataCenter.getServers();
        double loadToAllocate = request.load();

        for (Server server : servers) {
            if (loadToAllocate == 0) {
                break;
            }
            loadToAllocate = server.addLoad(loadToAllocate);
        }

        return loadToAllocate;
    }

    public void releaseResources(ResourceRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("request is null");
        }

        List<Server> servers = dataCenter.getServers();
        double loadToRealise = request.load();

        for (Server server : servers) {
            if (loadToRealise == 0) {
                return;
            }
            loadToRealise = server.releaseLoad(loadToRealise);
        }
    }

    public void optimize() {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        }
    }
}
