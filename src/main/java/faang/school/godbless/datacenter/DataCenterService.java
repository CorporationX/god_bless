package faang.school.godbless.datacenter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public static void addServer(Server server){
        DataCenter.getServersList().add(server);
    }

    public static void removeServer(Server server){
        DataCenter.getServersList().remove(server);
    }

    public int getTotalEnergyConsumption(){
        int totalConsumption = 0;

        for (Server server : DataCenter.getServersList()){
            totalConsumption += server.getEnergyConsumption();
        }
        return totalConsumption;
    }

    public void allocateResources(ResourceRequest request){
        double loadRequired = request.getLoad();

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
        throw new IllegalStateException("Not enough resources to fulfill the request");
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
}
