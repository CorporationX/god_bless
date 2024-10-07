package school.faang.bjs2_33282_dataCenter;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DataCenterService implements LoadBalancingOptimizationStrategy {

    public void initiateDataCenter(DataCenter dataCenter, List<ResourceRequest> requests) {
        Server.maxLoad = 100;
        for (ResourceRequest request : requests) {
            manageRequest(dataCenter, request);
        }
    }

    @Override
    public void loadBalancingOptimizationStrategy(DataCenter dataCenter, double maxLoad) {
        Server.maxLoad = maxLoad;
        double currentLoad = getCurrentLoad(dataCenter);
        ResourceRequest dataToOptimize = new ResourceRequest(currentLoad, true);
        dataCenter.getServers().clear();
        manageRequest(dataCenter, dataToOptimize);
    }

    private void manageRequest(DataCenter dataCenter, ResourceRequest request) {
        if (request.isToAdd()) {
            if (getTotalFreeLoad(dataCenter) <= request.getLoad()) {
                do {
                    addServer(dataCenter);
                } while (getTotalFreeLoad(dataCenter) < request.getLoad());
            }
            allocateResources(dataCenter, request.getLoad());
        } else {
            releaseResources(dataCenter, request.getLoad());
        }
        deleteServer(dataCenter);
    }

    private void addServer(DataCenter dataCenter) {
        dataCenter.getServers().add(new Server());
    }

    private void deleteServer(DataCenter dataCenter) {
        while (dataCenter.getServers().remove(new Server())) {
            dataCenter.getServers().remove(new Server());
        }
    }

    private double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getServers().size() * Server.energyConsumption;
    }

    private void allocateResources(DataCenter dataCenter, double loadToAllocate) {
        sortServersByLoad(dataCenter, true);
        double leftToAllocate = loadToAllocate;
        for (Server server : dataCenter.getServers()) {
            if (leftToAllocate <= 0) {
                break;
            }
            double serverFreeLoad = Server.maxLoad - server.getLoad();
            if (serverFreeLoad > leftToAllocate) {
                server.setLoad(server.getLoad() + leftToAllocate);
                leftToAllocate -= serverFreeLoad;
            } else {
                server.setLoad(Server.maxLoad);
                leftToAllocate -= serverFreeLoad;
            }
        }
    }

    private void releaseResources(DataCenter dataCenter, double loadToRelease) {
        sortServersByLoad(dataCenter, false);
        double leftToRelease = loadToRelease;
        for (Server server : dataCenter.getServers()) {
            if (leftToRelease <= 0) {
                break;
            }
            double serverLoad = server.getLoad();
            if (serverLoad > leftToRelease) {
                server.setLoad(server.getLoad() - leftToRelease);
            } else {
                server.setLoad(0);
                leftToRelease -= serverLoad;
            }
        }
    }

    private double getCurrentLoad(DataCenter dataCenter) {
        double currentLoad = 0;
        for (Server server : dataCenter.getServers()) {
            currentLoad += server.getLoad();
        }
        return currentLoad;
    }

    private double getTotalFreeLoad(DataCenter dataCenter) {
        double totalCapacity = dataCenter.getServers().size() * Server.maxLoad;
        double currentLoad = getCurrentLoad(dataCenter);
        return totalCapacity - currentLoad;
    }

    private void sortServersByLoad(DataCenter dataCenter, boolean isDescending) {
        if (isDescending) {
            dataCenter.getServers().sort(Comparator.comparingDouble(Server::getLoad).reversed());
        } else {
            dataCenter.getServers().sort(Comparator.comparingDouble(Server::getLoad));
        }
    }
}
