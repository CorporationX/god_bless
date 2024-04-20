package faang.school.godbless.optimizingDataCenter;

import lombok.Data;

@Data
public class DataCenterService {
    private final DataCenter dataCenter = new DataCenter();

    public void addServer(double load, double maxLoad) {
        dataCenter.getServers().add(new Server(load, maxLoad));
    }

    public void removeServer(Server serverToRemove) {
        dataCenter.getServers().remove(serverToRemove);
        allocateResources(new ResourceRequest(serverToRemove.getLoad()));
    }

    public double getTotalEnergyConsumption() {
         return dataCenter.getServers().stream()
                 .map(Server::getEnergyConsumption)
                 .reduce(0.0,Double::sum);
    }

    public void allocateResources(ResourceRequest request) {
        double leftToAllocate = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if ((server.getMaxLoad() - server.getLoad()) >= leftToAllocate) {
                server.setLoad(server.getLoad() + leftToAllocate);
                return;
            } else {
                double availableLoad = server.getMaxLoad() - server.getLoad();
                server.setLoad(server.getMaxLoad());
                leftToAllocate -= availableLoad;
            }
        }if(leftToAllocate > 0){
            releaseResources(new ResourceRequest(leftToAllocate));
            allocateResources(new ResourceRequest(leftToAllocate));
        }
    }

    public void releaseResources(ResourceRequest request) {
        double leftToRelease = request.getLoad();
        for (Server server : dataCenter.getServers()) {
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

