package faang.school.godbless.optimizedatacenter;

import faang.school.godbless.optimizedatacenter.optimization.OptimizationStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService {

    private DataCenter dataCenter;


    public void addServer(Server server) {
        if (server == null) {
            return;
        }
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        if (server == null) {
            return;
        }
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers()
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public boolean allocateResources(ResourceRequest request) {
        if (dataCenter.getServers().isEmpty()) {
            return false;
        }

        Server maxAvailableLoadServer = dataCenter.getAvailableLoadServer();
        if (maxAvailableLoadServer.getAvailableLoad() < request.getLoad()) {
            return false;
        }
        maxAvailableLoadServer.setLoad(maxAvailableLoadServer.getLoad() + request.getLoad());
        return true;
    }

    public boolean releaseResources(ResourceRequest request) {
        if (dataCenter.getServers().isEmpty()) {
            return false;
        }

        Server maxLoadServer = dataCenter.getMaxLoadServer();

        if (maxLoadServer.getLoad() < request.getLoad()) {
            maxLoadServer.setLoad(0);
            return true;
        }

        maxLoadServer.setLoad(maxLoadServer.getLoad() - request.getLoad());
        return true;
    }

    public void optimize(OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }
}
