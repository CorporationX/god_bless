package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

public class DataCenterService {
    private static final Logger logger = LoggerFactory.getLogger(DataCenterService.class);
    private final Timer timer = new Timer();
    private static final long INTERVAL = 30 * 60 * 1000;

    public void addServer(DataCenter dataCenter, Server server) {
        validateDataCenter(dataCenter);
        dataCenter.getServers().add(server);
        logger.info("Server {} added to the data center {}", server, dataCenter);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        validateDataCenter(dataCenter);
        if (!dataCenter.getServers().contains(server)) {
            logger.warn("There's no server {} in the data center {}", server, dataCenter);
            return;
        }
        dataCenter.getServers().remove(server);
        logger.info("Server {} removed from data center {}", server, dataCenter);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        validateDataCenter(dataCenter);
        double energyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            energyConsumption += server.getEnergyConsumption();
        }
        return energyConsumption;
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        validateDataCenter(dataCenter);
        double allocated = 0;
        for (Server server : dataCenter.getServers()) {
            double availableLoad = Math.min(request.getLoad() - allocated, server.getMaxLoad() - server.getLoad());
            allocated += availableLoad;
            server.setLoad(server.getLoad() + availableLoad);
            if (allocated == request.getLoad()) {
                return true;
            }
        }
        return false;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        validateDataCenter(dataCenter);
        validateResourceRequest(request);
        double released = 0;
        for (Server server : dataCenter.getServers()) {
            double loadReduction = Math.min(request.getLoad() - released, server.getLoad());
            released += loadReduction;
            server.setLoad(server.getLoad() - loadReduction);
            if (released == request.getLoad()) {
                logger.info("Load from request {} was completely removed", request);
                return;
            }
        }
    }

    public void optimize(OptimizationStrategy strategy, DataCenter dataCenter) {
        validateDataCenter(dataCenter);
        validateStrategy(strategy);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.info("Optimizing the data center {}", dataCenter);
                strategy.optimize(dataCenter);
            }
        }, 0, INTERVAL);
    }

    public void shutdown() {
        timer.cancel();
        timer.purge();
    }

    private void validateStrategy(OptimizationStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("The strategy can't be null");
        }
    }

    private void validateDataCenter(DataCenter dataCenter) {
        if (dataCenter == null) {
            throw new IllegalArgumentException("The data center can't be null");
        }
    }

    private void validateResourceRequest(ResourceRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("The resource request can't be null");
        }
    }
}
