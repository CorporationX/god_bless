package faang.school.godbless.data_center;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class DataCenterService implements OptimizationStrategy{

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

    @Override
    public void optimize(DataCenter dataCenter) {
        Map<Server, Double> loadMap = new HashMap<>();

        for (Server server : dataCenter.getServerList()) {
            loadMap.put(server, server.getMaxLoad()- server.getLoad());
        }

        Server maxLoadedServer = Collections.min(loadMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        Server minLoadedServer = Collections.max(loadMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        double availableMaxLoadedServer = maxLoadedServer.getMaxLoad()- maxLoadedServer.getLoad();
        double availableMinLoadedServer = minLoadedServer.getMaxLoad()- minLoadedServer.getLoad();

        double equalLoad = (availableMaxLoadedServer +availableMinLoadedServer)/2;
        System.out.println(maxLoadedServer + "   " + minLoadedServer);
        double transferredLoad = equalLoad - availableMaxLoadedServer;
        System.out.println("trasfer:"  + transferredLoad);
        maxLoadedServer.setLoad(maxLoadedServer.getLoad()-transferredLoad);
        minLoadedServer.setLoad(minLoadedServer.getLoad()+transferredLoad);

        System.out.println("Max load optimization strategy applied on server: " + maxLoadedServer);
    }
}
