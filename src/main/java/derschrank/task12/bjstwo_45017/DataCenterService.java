package derschrank.task12.bjstwo_45017;

import derschrank.task12.bjstwo_45017.servers.Server;

public class DataCenterService {
    DataCenter dataCenter;

    public DataCenterService() {
        this.dataCenter = new DataCenter();
    }

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }


    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public double getTotalAvailableLoad() {
        double totalAvailableLoad = 0;
        for (Server server : dataCenter.getServers()) {
            totalAvailableLoad += server.getAvailableLoad();
        }
        return totalAvailableLoad;
    }

    public void allocateResources(ResourceRequest request) {
        double moreNeedResource = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (moreNeedResource == 0) {
                break;
            }
            double resourcesFromThisServer = Math.min(server.getAvailableLoad(), moreNeedResource);
            if(server.allocateLoad(resourcesFromThisServer)) {
                moreNeedResource -= resourcesFromThisServer;
            };
        }
        if (moreNeedResource > 0) {
            System.out.println("We don't have resources for this Request");
            releaseResources(new ResourceRequest(request.getLoad() - moreNeedResource));
        }
    }

    public void releaseResources(ResourceRequest request) {
        double moreNeedResourceToRelease = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (moreNeedResourceToRelease == 0) {
                break;
            }
            double resourcesFromThisServer = Math.min(server.getLoad(), moreNeedResourceToRelease);
            if(server.releaseLoad(resourcesFromThisServer)) {
                moreNeedResourceToRelease -= resourcesFromThisServer;
            };
        }

    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(dataCenter.toString());
        result.append("\nTotalAvailableLoad: ");
        result.append(getTotalAvailableLoad());
        result.append("\nTotalEnergyConsumption: ");
        result.append(getTotalEnergyConsumption());
        result.append("\n");
        return result.toString();
    }
}
