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
        dataCenter.getSERVERS().add(server);
        dataCenter.getSERVER_INDEXES().put(server, dataCenter.getSERVERS().size() - 1);
    }

    public void removeServer(Server server) {
        if (server == null) {
            return;
        }
        int serversIndex = dataCenter.getSERVER_INDEXES().get(server);
        dataCenter.getSERVERS().remove(serversIndex);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getSERVERS()
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public boolean allocateResources(ResourceRequest request) {
        if (dataCenter.getSERVERS().isEmpty()) {
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
        if (dataCenter.getSERVERS().isEmpty()) {
            return false;
        }

        Server maxLoadServer = dataCenter.getMaxLoadServer();

        if (maxLoadServer.getLoad() < request.getLoad()) {
            return false;
        }

        maxLoadServer.setLoad(maxLoadServer.getLoad() - request.getLoad());
        return true;
    }

    public void optimize(OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }
}
