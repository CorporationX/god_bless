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

    private double getTotalEnergyConsumption(){
        double totalEnergyConsumption = 0.00;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    private boolean allocateResources(ResourceRequest request){
        for (Server server : dataCenter.getServers()) {
            if (server.canAllocate(request.getLoad())) {
                dataCenter.getResourceRequests().put(request, server);
                server.allocateLoad(request.getLoad());
                return true;
            }
        }
        return false;
    }

    public void releaseResources(ResourceRequest request) {
        Server server = dataCenter.getResourceRequests().get(request);
        server.releaseLoad(request.getLoad());
        dataCenter.getResourceRequests().remove(request);
    }

    public void optimize(){

    }
}
