package faang.school.godbless.beksultan2005;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService {
    private final DataCenterService dataCenterService;
    private DataCenter dataCenter;

    public void addServer(Server server) {
        dataCenterService.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenterService.removeServer(server);
    }

    private void getTotalEnergyConsumption(){

    }

    private boolean allocateResources(ResourceRequest request){
        for (Server server : dataCenter.getServers()) {
            if (server.canAllocate(request.getLoad())) {
                server.allocateLoad(request.getLoad());
                return true;
            }
        }
        return false;
    }

    public void releaseResources(ResourceRequest request) {
        double load;
        for (Server server : dataCenter.getServers()) {
            load = server.releaseLoad(request.getLoad());
            if (load == 0){
                break;
            }
        }
    }

}
