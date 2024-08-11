package faang.school.godbless.BJS2_19559;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public boolean isAllocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.canAllocate(request.getLoad())) {
                server.allocate(request.getLoad());
                return true;
            }
        }
        return false;
    }

    public void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() >= request.getLoad()) {
                server.release(request.getLoad());
                break;
            }
        }
    }

    public void optimize() {
        optimizationStrategy.optimize(dataCenter);
    }
}
