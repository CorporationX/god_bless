package faang.school.godbless.optimization;

import java.util.ArrayList;
import java.util.List;

public class DataCenterService implements OptimizationStrategy{
    private List<Server> servers = new ArrayList<>();
    public void addServer(Server server){
        servers.add(server);
    }
    public void removeServer(Server server){
        servers.remove(server);
    }
    public double getTotalEnergyConsumption(){
        double totalEnergyConsumption = 0;
        for (Server server : servers){
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }
    public boolean allocateResources(ResourceRequest request){
        double requestLoad = request.getLoad();
        if (!allocationIsPossible(servers, requestLoad)){
            return false;
        }
        for (Server server : servers) {
            if (server.getAvailableCapacity() > requestLoad) {
                server.setLoad(server.getLoad() + requestLoad);
                requestLoad -= server.getLoad();
            }
            if (server.getAvailableCapacity() < requestLoad) {
                server.setLoad(server.getMaxLoad());
                requestLoad = 0;
            }
            if (requestLoad == 0) {
                return true;
            }
        }
        return true;
    }

    public boolean releaseResources(ResourceRequest request){
        double requestLoad = request.getLoad();
        if (servers.isEmpty()){
            return false;
        }
        for (Server server : servers){
            if (requestLoad > server.getLoad()){
                requestLoad = server.getLoad() - requestLoad;
                server.setLoad(0);
            }
            if (requestLoad < server.getLoad()){
                server.setLoad(server.getLoad() - requestLoad);
                requestLoad = 0;
            }
            if (requestLoad == 0){
                return true;
            }
        }
        return true;


    }


    private boolean allocationIsPossible(List<Server> servers, double load){
        double availableCapacity = 0.0;
        for (Server server : servers){
            availableCapacity += server.getAvailableCapacity();
        }
        return load <= availableCapacity;
    }

    @Override
    public void optimize(DataCenter dataCenter) {

        //Использовать этот метод в DataCenterService для
        // оптимизации нагрузки на дата-центр. Например, создать
        // метод, который будет проводить оптимизацию нагрузки
        // каждые полчаса.
    }
}
