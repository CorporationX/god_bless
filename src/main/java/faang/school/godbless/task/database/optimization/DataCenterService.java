package faang.school.godbless.task.database.optimization;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DataCenterService {
    @Getter
    private final DataCenter dataCenter;
    private final LoadBalancingOptimizationStrategy loadBalance;

    public void addNewServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption() {
        List<Server> servers = dataCenter.getServers();
        double energyConsumption = 0;
        for (Server server : servers) {
            energyConsumption += server.getEnergyConsumption();
        }
        return energyConsumption;
    }

    public void allocateResources(ResourceRequest resourceRequest) {
        if (dataCenter.getServers().size() == 0) {
            dataCenter.getServers().add(new Server());
        }
        int numberOfServers = dataCenter.getServers().size();
        for (int i = 0; i < numberOfServers; i++) {
            if (dataCenter.getNextServer().allocateLoad(resourceRequest.load())) {
                return;
            }
        }
        loadBalance.optimize(dataCenter);
        allocateResources(resourceRequest);
    }

    public void releaseResources(ResourceRequest resourceRequest) {
        int numberOfServers = dataCenter.getServers().size();
        for (int i = 0; i < numberOfServers; i++) {
            if (dataCenter.getNextServer().releaseLoad(resourceRequest.load())) {
                return;
            }
        }
        loadBalance.optimize(dataCenter);
        allocateResources(resourceRequest);
    }
}
