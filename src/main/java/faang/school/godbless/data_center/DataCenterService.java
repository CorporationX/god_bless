package faang.school.godbless.data_center;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataCenterService{

    private DataCenter dataCenter;


    public void addServer(Server server) {
        dataCenter.getServerList().add(server);
        System.out.println("Server added to datacenter: " + server);
    }

    public void deleteServer(Server server) {
        dataCenter.getServerList().remove(server);
        System.out.println("Server deleted from datacenter: " + server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServerList()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public void allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServerList()) {
            if (server.getMaxLoad() >= (server.getLoad() + request.getLoad())) {
                server.setLoad(server.getLoad() + request.getLoad());
                System.out.println("Resources allocated successfully on server: " + server);
                return;
            }
        }
        System.out.println("Failed to allocate resources: No available servers.");
    }

    public void releaseResources(ResourceRequest request) {

        for (Server server : dataCenter.getServerList()) {
            if (server.getLoad() >= request.getLoad()){
                server.setLoad(server.getLoad() - request.getLoad());
                System.out.println("Resources released successfully on server: " + server);
                return;
            }
        }
        System.out.println("Failed to release resources: No sufficient resources available.");
    }

   public void optimizeDataCenter(OptimizationStrategy strategy){
        strategy.optimize( dataCenter );
   }
}
