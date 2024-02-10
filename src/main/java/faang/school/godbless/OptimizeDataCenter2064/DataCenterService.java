package faang.school.godbless.OptimizeDataCenter2064;

import lombok.Getter;

import java.util.List;

@Getter
public class DataCenterService {

    private DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addServer(Server server) {
        this.dataCenter.getServerList().add(server);
    }

    public void removeServer(Server server) {
        this.dataCenter.getServerList().remove(server);
    }

    public double getTotalEnergyConsumption(List<Server> serverList) {
        double totalConsumption = 0.0;
        for (Server server : serverList) {
            totalConsumption += server.getEnergyConsumption();
        }
        return totalConsumption;
    }

    public boolean allocateResources(ResourceRequest request) {
        double requestedLoad = request.getLoad();
        List<Server> serverList = this.dataCenter.getServerList();
        if (allocationIsAvailable(serverList, requestedLoad)) {
            return false;
        } else {
            for (Server server : serverList) {
                double currentStorageAvailable = server.getMaxLoad() - server.getLoad();
                if (currentStorageAvailable <= requestedLoad) {
                    server.setLoad(server.getLoad() + currentStorageAvailable);
                    requestedLoad -= currentStorageAvailable;
                } else {
                    server.setLoad(server.getLoad() + requestedLoad);
                    break;
                }
            }
            return true;
        }
    }

    public boolean releaseResources(ResourceRequest request) {
        double requestedLoad = request.getLoad();
        List<Server> serverList = this.dataCenter.getServerList();
        if (areServersEmpty(serverList)) {
            return false;
        }
        for (Server server : serverList) {
            double currentLoad = server.getLoad();
            if (server.getLoad() - requestedLoad <= 0) {
                server.setLoad(0);
                requestedLoad -= currentLoad;
            } else {
                server.setLoad(server.getLoad() - requestedLoad);
            }
        }
        return true;
    }

    public void optimize(OptimizationStrategy optimization) {
        optimization.optimize(this.dataCenter);
    }

    private boolean allocationIsAvailable(List<Server> serverList, double load) {
        double totalStorageAvailable = 0.00000;
        for (Server server : serverList) {
            totalStorageAvailable += server.getMaxLoad() - server.getLoad();
        }
        return load > totalStorageAvailable;
    }

    private boolean areServersEmpty(List<Server> serverList) {
        double totalLoad = 0.00000;
        for (Server server : serverList) {
            totalLoad += server.getLoad();
        }
        return totalLoad == 0;
    }
}