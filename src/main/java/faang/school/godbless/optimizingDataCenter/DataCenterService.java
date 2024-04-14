package faang.school.godbless.optimizingDataCenter;

import lombok.Data;

@Data
public class DataCenterService {
    private final DataCenter DATA_CENTER = new DataCenter();

    public void addServer(double load, double maxLoad) {
        DATA_CENTER.getServers().add(new Server(load, maxLoad));
    }

    public void removeServer(Server serverToRemove) {
        DATA_CENTER.getServers().remove(serverToRemove);
        allocateResources(new ResourceRequest(serverToRemove.getLoad()));
    }

    public double getTotalEnergyConsumption() {
        double totalConsumption = 0;
        for (Server server : DATA_CENTER.getServers()) {
            totalConsumption += server.getEnergyConsumption();
        }
        return totalConsumption;
    }

    public void allocateResources(ResourceRequest request) {
        double leftToAllocate = request.getLoad();
        for (Server server : DATA_CENTER.getServers()) {
            if ((server.getMaxLoad() - server.getLoad()) >= leftToAllocate) {
                server.setLoad(server.getLoad() + leftToAllocate);
                return;
            } else {
                double availableLoad = server.getMaxLoad() - server.getLoad();
                server.setLoad(server.getMaxLoad());
                leftToAllocate -= availableLoad;
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        double leftToRelease = request.getLoad();
        for (Server server : DATA_CENTER.getServers()) {
            if (server.getLoad() >= leftToRelease) {
                server.setLoad(server.getLoad() - leftToRelease);
                return;
            } else {
                leftToRelease = request.getLoad() - server.getLoad();
                server.setLoad(0);
            }
        }
    }
}

