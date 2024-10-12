package school.faang.datacenter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService implements OptimizationStrategy{
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public Double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream()
                .map(server -> server.getEnergyConsumption())
                .reduce((double) 0, Double::sum);
    }
    public boolean allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() + request.getLoad() < server.getMaxLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
                return true;
            }
        }
        return false;
    }

    public boolean releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() - request.getLoad() > 0) {
                server.setLoad(server.getLoad() - request.getLoad());
                return true;
            }
        }
        return false;
    }

    public void printAllServer() {
        for (Server server : dataCenter.getServers()) {
            System.out.println(server);
        }
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        optimizationStrategy.optimize(dataCenter);
    }
}