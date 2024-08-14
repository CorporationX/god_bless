package faang.school.godbless.task19457;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService implements OptimizationStrategy{

    private DataCenter dataCenter;


    public void addServer(Server server){
        dataCenter.getListOfServers().add(server);
    }
    public void removeServer(Server server){
        dataCenter.getListOfServers().remove(server);
    }
    public double getTotalEnergyConsumption(){
        return dataCenter.getListOfServers().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }
    public boolean allocateResources(ResourceRequest request){
        int size = dataCenter.getListOfServers().size();
        for (int i = 0; i < size; i++) {
            if(dataCenter.getListOfServers().get(i).getLoad() < dataCenter.getListOfServers().get(i).getMaxLoad()) {
                return dataCenter.getListOfServers().get(i).addLoad(request.getLoadForRequest());
            } else {
                return dataCenter.getListOfServers().get(i + 1).addLoad(request.getLoadForRequest());
            }
        }
        return false;
    }
    public void releaseResources(ResourceRequest request){
        for (Server server : dataCenter.getListOfServers()) {
            server.removeLoad(request.getLoadForRequest());
        }
    }
    @Override
    public void optimize(DataCenter dataCenter) {
        double averageLoad = dataCenter.getListOfServers().size()
                /dataCenter.getListOfServers().stream().mapToDouble(Server::getLoad).sum();

        for (Server server : dataCenter.getListOfServers()) {
            if(server.getLoad() > averageLoad){
                double differenceLoad = server.getLoad() - averageLoad;
                for (Server lessBusyServer : dataCenter.getListOfServers()) {
                    lessBusyServer.addLoad(differenceLoad);
                    server.removeLoad(differenceLoad);
                }
            }
        }

    }
}
