package school.faang.sprint_1.task_45027;

import java.util.HashMap;
import java.util.Map;

public class DataCenterService {
    DataCenter dataCenter;
    OptimizationStrategy optimizationStrategy;
    static Map<Server, Double> allocatedLoads = new HashMap<>();

    public DataCenterService(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        this.dataCenter = dataCenter;
        this.optimizationStrategy = optimizationStrategy;
    }

    public void addServer(Server server) {
        dataCenter.servers.add(server);
    }

    public void removeServer(Server server) {
        dataCenter.servers.remove(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergy = 0;

        for (Server server : dataCenter.servers) {
            totalEnergy += server.getEnergyConsumption();
        }
        return totalEnergy;
    }

    public void allocateResources(ResourceRequest request) {
        optimizationStrategy.optimize(dataCenter, request);
    }

    public void releaseResources(ResourceRequest request) {
        double totalReleaseLoad = 0;

        for (Server server : dataCenter.servers) {
            double serverReleaseLoad = allocatedLoads.get(server);
            server.setLoad(server.getLoad() - serverReleaseLoad);
            totalReleaseLoad += serverReleaseLoad;
        }

        request.setLoad(request.getLoad() + totalReleaseLoad);
    }
}
