package faang.school.godbless.task_13;

import lombok.Data;

@Data
public class DataCenterService implements OptimizationStrategy {
    private final DataCenter center = new DataCenter();

    public void addServer(Server server) {
        center.getServers().add(server);
    }

    public void removeServer(Server server) {
        center.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : center.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public void allocateResources(ResourceRequest request) {
        if (center.getServers().isEmpty()) {
            return;
        }
        Server minLoadServer = center.getServers().get(0);
        double minLoad = minLoadServer.getLoad();
        for (Server server : center.getServers()) {
            if (server.getLoad() < minLoad) {
                minLoad = server.getLoad();
                minLoadServer = server;
            }
        }
        double newLoad = minLoad + request.getLoad();
        minLoadServer.setLoad(newLoad);
        if (newLoad > minLoadServer.getMaxLoad()) {
            minLoadServer.setMaxLoad(newLoad);
        }
    }

    public void releaseResources(ResourceRequest request) {
        if (center.getServers().isEmpty()) {
            return;
        }
        Server maxLoadServer = center.getServers().get(0);
        double maxLoad = maxLoadServer.getLoad();
        for (Server server : center.getServers()) {
            if (server.getLoad() > maxLoad) {
                maxLoad = server.getLoad();
                maxLoadServer = server;
            }
        }
        double newLoad = maxLoad - request.getLoad();
        maxLoadServer.setLoad(newLoad);
    }

    @Override
    public void optimize(DataCenter dataCenter) {

    }
}
