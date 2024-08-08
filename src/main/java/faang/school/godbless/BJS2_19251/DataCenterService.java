package faang.school.godbless.BJS2_19251;

import java.util.List;

public class DataCenterService {

    private DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addServer(Server server){
        dataCenter.getServers().add(server);
    }

    public List<Server> getServers(){
        return dataCenter.getServers();
    }

    public void removeServer(Server server){
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption(){
        return this.dataCenter.getServers().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public void allocateResources(ResourceRequest request){
        Server availableServer = dataCenter.getServers().stream()
                .filter(server -> server.getMaxLoad() - server.getLoad() >= request.getLoad()).findFirst().orElse(null);

        if(availableServer != null){
            availableServer.setLoad(availableServer.getLoad() + request.getLoad());
        } else {
            System.out.println("no available servers");
        }
    }

    public void releaseResources(ResourceRequest request){
        dataCenter.getServers().stream()
                .filter(server -> server.getMaxLoad() == server.getLoad()).forEach(currServ -> {
                    if(currServ.getLoad() < request.getLoad()){
                        currServ.setLoad(0);
                        request.setLoad(request.getLoad() - currServ.getMaxLoad());
                    } else {
                        currServ.setLoad(currServ.getLoad() - request.getLoad());
                    }
                });
    }
}
