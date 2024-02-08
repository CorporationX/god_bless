package faang.school.godbless.hash_map.data_centers;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;

    public void addServer(Server server) {
        dataCenter.getServerList().add(server);
    }

    public void deleteServer(Server server) {
        dataCenter.getServerList().remove(server);
    }

    public double getTotalEnergyConsumption() {
        double allEnergyConsumption = 0.0d;
        for (Server server : dataCenter.getServerList()) {
            allEnergyConsumption += server.getEnergyConsumption();
        }
        return allEnergyConsumption;
    }

    public void allocateResources(ResourceRequest request){
        for(Server server: dataCenter.getServerList()){
            if(isAllocateResources(server, request)){
                server.setLoad(server.getLoad() + request.getLoad());
                break;
            }
        }
    }
    public void releaseResources(ResourceRequest request){
        for(Server server: dataCenter.getServerList()){
            if(isReleaseResources(server, request)){
                server.setLoad(server.getLoad() - request.getLoad());
                break;
            }
        }
    }

    private boolean isAllocateResources(Server server, ResourceRequest request){
        return server.getMaxLoad() - server.getLoad() >= request.getLoad();
    }

    private boolean isReleaseResources(Server server, ResourceRequest request){
        return server.getLoad() >= request.getLoad();
    }

    public void optimizationLoad(OptimizationStrategy strategy) {
        strategy.optimization(dataCenter);
    }
}
