package school.faang.bjs2_79724;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DataCenterService implements OptimizationStrategy {

    private final OptimizationStrategy optimizationStrategy;

    public void addServer(DataCenter dataCenter, Server server) {
        if (dataCenter.getServers().contains(server)) {
            log.info("This server already exists!");
        } else {
            dataCenter.addServer(server);
            log.info("Successfully added this server!");
        }
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        if (dataCenter.getServers().contains(server)) {
            dataCenter.removeServer(server);
            log.info("Server removed.");
        } else {
            log.info("Server not found in the data center.");
        }
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double remainingLoad = request.getLoad();

        for (Server server : dataCenter.getServers()) {
            double availableCapacity = server.getMaxLoad() - server.getLoad();
            if (availableCapacity > 0) {
                double loadToAssign = Math.min(availableCapacity, remainingLoad);
                server.setLoad(server.getLoad() + loadToAssign);
                remainingLoad -= loadToAssign;

                server.setEnergyConsumption(server.getLoad() * 1.5);

                if (remainingLoad <= 0) {
                    optimize(dataCenter);
                    return true;
                }
            }
        }

        log.warn("Not enough capacity to handle the request.");

        return false;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double loadToRelease = request.getLoad();

        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() > 0) {
                double loadOnServer = server.getLoad();
                double released = Math.min(loadOnServer, loadToRelease);
                server.setLoad(loadOnServer - released);
                loadToRelease -= released;

                server.setEnergyConsumption(server.getLoad() * 1.5);

                if (loadToRelease <= 0) {
                    break;
                }
            }
        }

        log.info("Released resources of request with load: {}", request.getLoad());
    }

    public double getTotalLoad(DataCenter dataCenter) {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getLoad)
                .sum();
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        optimizationStrategy.optimize(dataCenter);
    }
}
