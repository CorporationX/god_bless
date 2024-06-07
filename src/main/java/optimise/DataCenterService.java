package optimise;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService {

    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public void addService(Server server){
        dataCenter.addServer(server);
    }

    public void removeService(Server server){
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption(){
        double result = 0;
        for(Server server: dataCenter.getServers()){
            result += server.getEnergyConsumption();
        }
        return result;
    }

    public void allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.takeLoad(request.getLoad())) {
                System.out.println("Resources were allocated");
                return;
            }
        }
    }
    public void releaseResources(ResourceRequest request) {
        for(Server server : dataCenter.getServers()) {
            if(server.releaseLoad(request.getLoad())) {
                System.out.println("Resources were released");
                return;
            }
        }
    }

    public void optimiseDataCenter(){
        optimizationStrategy.optimize(dataCenter);
    }

}
