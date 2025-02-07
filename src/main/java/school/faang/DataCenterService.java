package school.faang;

import java.util.Timer;
import java.util.TimerTask;

public class DataCenterService {
    private final Timer timer = new Timer();

    public void addServer(DataCenter dataCenter, Server server) {
        validateDataCenter(dataCenter);
        dataCenter.servers.add(server);
        System.out.printf("Server %s added to the data center %s \n", server, dataCenter);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        validateDataCenter(dataCenter);
        if (!dataCenter.servers.contains(server)) {
            System.out.printf("There's no server %s in the data center %s\n", server, dataCenter);
            return;
        }
        dataCenter.servers.remove(server);
        System.out.printf("Server %s removed from data center %s\n", server, dataCenter);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        validateDataCenter(dataCenter);
        double energyConsumption = 0;
        for (Server server : dataCenter.servers) {
            energyConsumption += server.getEnergyConsumption();
        }
        return energyConsumption;
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        validateDataCenter(dataCenter);
        double allocated = 0;
        for (Server server : dataCenter.servers) {
            double availableLoad = Math.min(request.getLoad() - allocated, server.getMaxLoad() - server.getLoad());
            allocated += availableLoad;
            server.setLoad(server.getLoad() + availableLoad);
            if (allocated == request.getLoad()) {
                return true;
            }
        }
        return false;
    }

    void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        validateDataCenter(dataCenter);
        validateResourceRequest(request);
        double released = 0;
        for (Server server : dataCenter.servers) {
            double loadReduction = Math.min(request.getLoad() - released, server.getLoad());
            released += loadReduction;
            server.setLoad(server.getLoad() + loadReduction);
            if (released == request.getLoad()) {
                System.out.printf("Load from request %s was completely removed\n", request);
                return;
            }
        }
    }

    public void optimize(OptimizationStrategy strategy, DataCenter dataCenter) {
        validateDataCenter(dataCenter);
        validateStrategy(strategy);
        int interval = 30 * 60 * 1000;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.printf("Optimizing the data center %s \n", dataCenter);
                strategy.optimize(dataCenter);
            }
        }, 0, interval);
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