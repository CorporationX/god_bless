package school.faang.task_45018;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DataCenterService {
    private final DataCenter dataCenter;
    private final OptimizationStrategy optimizationStrategy;

    public void addServer(Server server) {
        if (server == null) {
            throw new IllegalArgumentException("Server doesn't exist");
        }
        dataCenter.getDataCenters().add(server);
    }

    public void removeServer(Server server) {
        if (server == null) {
            throw new IllegalArgumentException("Server doesn't exist");
        }
        dataCenter.getDataCenters().remove(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getDataCenters().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(ResourceRequest resourceRequest) {
        double remainingLoad = resourceRequest.getLoad();
        List<Server> servers = dataCenter.getDataCenters();
        for (Server server : servers) {
            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (availableLoad > 0) {
                double allocate = Math.min(availableLoad, remainingLoad);
                server.setLoad(server.getLoad() + allocate);
                remainingLoad -= allocate;
            }
            if (remainingLoad <= 0) {
                System.out.println("OK");
                return;
            }
        }
        System.out.println("Resource requested is too large");
    }

    public void releaseResources(ResourceRequest request) {
        double remainingLoad = request.getLoad();
        List<Server> servers = dataCenter.getDataCenters();
        for (Server server : servers) {
            double release = Math.min(request.getLoad(), remainingLoad);
            server.setLoad(server.getLoad() - release);
            remainingLoad -= release;
            if (remainingLoad <= 0) {
                System.out.println("OK");
            }
        }
        System.out.println("Resource requested is too large");
    }

    public void optimize() {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        }
    }
}
