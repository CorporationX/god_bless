package school.faang.data_center.service;

import lombok.Setter;
import school.faang.data_center.model.ResourceRequest;
import school.faang.data_center.model.Server;
import school.faang.data_center.model.DataCenter;
import school.faang.data_center.optimization_strategy.OptimizationStrategy;

import java.util.List;

@Setter
public class DataCenterService {

    private OptimizationStrategy optimizationStrategy;

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getAllServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        List<Server> servers = dataCenter.getAllServers();
        double requestLoad = request.getLoad();

        for (Server server : servers) {
            if (requestLoad <= 0) {
                break;
            }

            double availableServerLoad = server.getMaxLoad() - server.getLoad();
            double allocated = Math.min(availableServerLoad, requestLoad);

            server.setLoad(server.getLoad() + allocated);
            requestLoad -= allocated;
        }

        return requestLoad <= 0;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        for (Server server : dataCenter.getAllServers()) {
            if (server.getLoad() > 0) {
                double newLoad = server.getLoad() - request.getLoad();
                server.setLoad(Math.max(newLoad, 0));
                server.setEnergyConsumption(calculateEnergyConsumption(server));
            }
        }
    }

    private double calculateEnergyConsumption(Server server) {
        return 100 + server.getLoad() * 0.5;
    }

    public void optimizeResources(DataCenter dataCenter) {
        System.out.println("30 минут прошло");
        optimizationStrategy.optimize(dataCenter);
    }
}

