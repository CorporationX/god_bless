package school.faang.optimizing_data;

import java.util.Objects;
import java.util.logging.Logger;

public class DataCenterService {
    private static final Logger logger = Logger.getLogger(DataCenterService.class.getName());

    public void addServer(DataCenter dataCenter, Server server) {
        Objects.requireNonNull(dataCenter, "DataCenter cannot be null!");
        dataCenter.addServer(server);
        logger.info("Server added to the data center!");
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        Objects.requireNonNull(dataCenter, "DataCenter cannot be null!");
        dataCenter.removeServer(server);
        logger.info("Server removed from the data center!");
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        Objects.requireNonNull(dataCenter, "DataCenter cannot be null!");
        double totalEnergy = dataCenter.getTotalEnergyConsumption();
        logger.info("Total energy consumption: " + totalEnergy);
        return totalEnergy;
    }

    public void allocateResources(DataCenter dataCenter, ResourceRequest request) {
        Objects.requireNonNull(dataCenter, "DataCenter cannot be null!");
        Objects.requireNonNull(request, "ResourceRequest cannot be null!");

        double loadToAllocate = request.getLoad();
        boolean resourceAllocated = dataCenter.getServers().stream()
                .filter(server -> server.getLoad() + loadToAllocate <= server.getMaxLoad())
                .peek(server -> server.setLoad(server.getLoad() + loadToAllocate))
                .findFirst()
                .isPresent();

        if (resourceAllocated) {
            logger.info("Resources successfully allocated to a server!");
        } else {
            logger.warning("Failed to allocate resources. Not enough space on servers!");
        }
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        Objects.requireNonNull(dataCenter, "DataCenter cannot be null!");
        Objects.requireNonNull(request, "ResourceRequest cannot be null!");

        double loadToRelease = request.getLoad();
        dataCenter.getServers().stream()
                .filter(server -> server.getLoad() >= loadToRelease)
                .findFirst()
                .ifPresent(server -> {
                    server.setLoad(server.getLoad() - loadToRelease);
                    logger.info("Resources successfully released from the server!");
                });
    }

    public void applyOptimizationStrategy(DataCenter dataCenter, OptimizationStrategy strategy) {
        Objects.requireNonNull(dataCenter, "DataCenter cannot be null");
        Objects.requireNonNull(strategy, "OptimizationStrategy cannot be null");

        strategy.optimize(dataCenter);
        logger.info("Optimization strategy applied.");
    }
}
