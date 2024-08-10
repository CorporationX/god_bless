package faang.school.godbless;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

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

    public double getTotalLoad() {
        return dataCenter.getTotalLoad();
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getTotalEnergyConsumption();
    }

    public List<Server> getServers() {
        return dataCenter.getServers();
    }

    public boolean allocateResources(ResourceRequest request) {
        Optional<Server> availableServer = dataCenter.getServers().stream()
                .filter(server -> server.canHandleLoad(request.getLoad()))
                .findFirst();

        if (availableServer.isPresent()) {
            availableServer.get().allocateLoad(request.getLoad());

            return true;
        }

        return false;
    }

    public boolean releaseResources(ResourceRequest request) {
        Optional<Server> availableServer = dataCenter.getServers().stream()
                .filter(server -> server.canReleaseLoad(request.getLoad()))
                .findFirst();

        if (availableServer.isPresent()) {
            availableServer.get().releaseLoad(request.getLoad());

            return true;
        }

        return false;
    }

    public void optimize() {
        optimizationStrategy.optimize(dataCenter);
    }
}
