package faang.school.godbless.dataCenter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class DataCenterService {

    private final DataCenter dataCenter;

    public Server addServer(Server server) {
        if (!validateServer(server)) {
            System.out.println("Info: incorrect server for creating");
            return null;
        }

        List<Server> servers = dataCenter.getServers();

        if (servers == null) {
            servers = new ArrayList<>();
        }

        servers.add(server);

        return server;
    }

    public boolean deleteServer(Server server) {
        if (!validateServer(server)) {
            System.out.println("Info: incorrect server for deleting");
            return false;
        }

        List<Server> servers = dataCenter.getServers();

        if (servers == null) {
            servers = new ArrayList<>();
        }

        return servers.remove(server);
    }

    public Double getTotalEnergyConsumption() {
        List<Server> servers = dataCenter.getServers();

        if (servers == null) {
            throw new IllegalArgumentException("Data center contain null instead list of servers");
        }

        return servers.stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public boolean allocateResources(ResourceRequest request) {
        if (request == null || request.getLoad() == null) {
            System.out.println("Incorrect resource request for allocating");
            return false;
        }

        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() + request.getLoad() <= server.getMaxLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
                server.setEnergyConsumption(server.getEnergyConsumption() + request.getLoad());
            }
        }

        return true;
    }

    public boolean releaseResources(ResourceRequest request) {
        if (request == null || request.getLoad() == null) {
            System.out.println("Incorrect resource request for releasing");
            return false;
        }

        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() - request.getLoad() > 0) {
                server.setLoad(server.getLoad() - request.getLoad());
                server.setEnergyConsumption(server.getEnergyConsumption() - request.getLoad());
                return true;
            }
        }

        return false;
    }

    public void optimize(List<OptimizationStrategy> strategyList) {
        strategyList.forEach(strategy -> strategy.optimize(dataCenter));
    }

    private boolean validateServer(Server server) {
        if (server == null) {
            return false;
        }

        if (server.getEnergyConsumption() == null || server.getLoad() == null || server.getMaxLoad() == null) {
            return false;
        }

        return true;
    }
}
