package faang.school.godbless.datacenter;

import lombok.AllArgsConstructor;


public class DataCenterService implements OptimizationStrategy{
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addServer(Server server){
        dataCenter.getServersList().add(server);
    }

    public void removeServer(Server server, boolean forceDelete){
        if (forceDelete) {
            dataCenter.getServersList().remove(server);
        } else {
            double potentialLoad = getMaxServersLoad() - server.getMaxLoad();
            if (getTotalLoad() > potentialLoad) {
                throw new RuntimeException("Impossible to delete this server. Make sure to decrease total load by " + (getTotalLoad() - potentialLoad));
            } else {
                allocateResources(new ResourceRequest(server.getLoad()));
            }
        }
    }

    public int getTotalEnergyConsumption() {
        int totalConsumption = 0;

        for (Server server : dataCenter.getServersList()){
            totalConsumption += server.getEnergyConsumption();
        }
        return totalConsumption;
    }

    public int getTotalLoad() {
        int totalLoad = 0;

        for (Server server : dataCenter.getServersList()) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    public int getMaxServersLoad() {
        int maxLoad = 0;

        for (Server server : dataCenter.getServersList()) {
            maxLoad += server.getMaxLoad();
        }
        return maxLoad;
    }

    public void allocateResources(ResourceRequest request) {
        double loadRequired = request.getLoad();

        if (getMaxServersLoad() - getTotalLoad() >= loadRequired) {
            for (Server server : dataCenter.getServersList()) {
                double availableLoad = server.getMaxLoad() - server.getLoad();
                if (availableLoad >= loadRequired) {
                    server.increaseLoad(loadRequired);
                    return;
                } else {
                    server.increaseLoad(availableLoad);
                    loadRequired -= availableLoad;
                }
            }
        } else {
            throw new IllegalArgumentException("Not enough resources to fulfill the request");
        }
    }

    public void releaseResources(ResourceRequest request) {
        double loadToRelease = request.getLoad();

        for (Server server : dataCenter.getServersList()) {
            double loadOnServer = server.getLoad();
            if (loadOnServer > 0) {
                double loadReleased = Math.min(loadToRelease, loadOnServer);
                server.decreaseLoad(loadReleased);
                loadToRelease -= loadReleased;
                if (loadToRelease <= 0) {
                    return;
                }
            }
        }
        throw new RuntimeException("Not enough load to release");
    }

    @Override
    public void optimize() {
        double serversAmount = dataCenter.getServersList().size();
        double loadToBalance = getTotalLoad();
        double average = loadToBalance / serversAmount;

        for (Server server : dataCenter.getServersList()) {
            if (server.getMaxLoad() >= average) {
                server.setLoad(average);
            } else {
                double overLoad = average - server.getMaxLoad();
                server.setLoad(server.getMaxLoad());
                loadToBalance -= server.getMaxLoad();
                serversAmount--;
                average = loadToBalance / serversAmount;
            }
        }
    }

}
