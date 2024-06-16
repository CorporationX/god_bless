package faang.school.godbless.optimizing.work;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class DataCenterService {

    private DataCenter dataCenter;
    private LoadBalancingOptimizationStrategy loadBalancingOptimizationStrategy;

    public void addServer(Server server) {
        if(server != null) {
            dataCenter.addServer(server);
        }
        else {
            System.err.println("Error!");
        }
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server); // я так понимаю проверка не нужна потому что она есть в методе removeServer()
    }

    public double getTotalEnergyConsumption() {
        double totalEnergy = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergy += server.getEnergyConsumption();
        }
        return totalEnergy;
    }

    public boolean allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() + request.getLoad() <= server.getMaxLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
                return true;
            }
        }
        return false;
    }

    public void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() >= request.getLoad()) {
                server.setLoad(server.getLoad() - request.getLoad());
                return;
            }
        }
    }

    public void optimize() {
        loadBalancingOptimizationStrategy.optimize(dataCenter);
    }

}
