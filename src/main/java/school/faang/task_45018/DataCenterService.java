package school.faang.task_45018;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DataCenterService {
    private final OptimizationStrategy optimizationStrategy;

    public void addServer(Server server, @NonNull DataCenter dataCenter) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server, @NonNull DataCenter dataCenter) {
        if (server == null) {
            throw new IllegalArgumentException("Server doesn't exist");
        }
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption(@NonNull DataCenter dataCenter) {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public boolean allocateResources(ResourceRequest resourceRequest, @NonNull DataCenter dataCenter) {
        double remainingLoad = resourceRequest.getLoad();
        List<Server> servers = dataCenter.getServers();
        for (Server server : servers) {
            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (availableLoad > 0) {
                double allocate = Math.min(availableLoad, remainingLoad);
                server.setLoad(server.getLoad() + allocate);
                remainingLoad -= allocate;
            }
            if (remainingLoad <= 0) {
                System.out.println("OK");
                return true;
            }
        }
        System.out.println("Resource requested is too large");
        return false;
    }

    public boolean releaseResources(ResourceRequest request, @NonNull DataCenter dataCenter) {
        double remainingLoad = request.getLoad();
        List<Server> servers = dataCenter.getServers();
        for (Server server : servers) {
            double release = Math.min(server.getLoad(), remainingLoad);
            server.setLoad(server.getLoad() - release);
            remainingLoad -= release;
            if (remainingLoad <= 0) {
                System.out.println("All resources are released");
                return true;
            }
        }
        System.out.println("Resources remain");
        return false;
    }

    public void optimize(@NonNull DataCenter dataCenter) {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        }
    }
}
