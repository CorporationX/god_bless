package BJS2_5010;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataCenterService implements OptimizationStrategy {
    private DataCenter dataCenter;

    void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    void deleteServer(Server server) {
        if (server.getLoad() != 0) {
            System.out.println("Этот сервер еще не выполнил процессы");
        } else {
            dataCenter.getServers().remove(server);
        }
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    void allocateResources(ResourceRequest request) {
        var server = DataCenter.findLowLoadServer(dataCenter.getServers(), request);
        if (server != null) {
            server.setLoad(request.getLoad() + server.getLoad());
        } else {
            System.out.println("All server is busy");
        }
    }

    void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() == server.getMaxLoad()) {
                if (server.getMaxLoad() < request.getLoad()) {
                    server.setLoad(server.getLoad() - request.getLoad());
                    request.setLoad(Math.abs(server.getLoad()));
                    server.setLoad(0);
                } else {
                    server.setLoad(server.getLoad() - request.getLoad());
                    break;
                }
            }
        }
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        double loadServers = dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
        double maxLoadServers = dataCenter.getServers().stream().mapToDouble(Server::getMaxLoad).sum();
        double divisonLoadOnServer = loadServers / maxLoadServers;
        for (Server server : dataCenter.getServers()) {
            server.setLoad(divisonLoadOnServer * server.getMaxLoad());
        }

    }
}
