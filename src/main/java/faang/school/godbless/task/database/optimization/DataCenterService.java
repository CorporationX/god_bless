package faang.school.godbless.task.database.optimization;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class DataCenterService {
    private static final int LIMIT_OF_OPTIMIZATION_ATTEMPT = 3;

    @Getter
    private final DataCenter dataCenter;
    private final LoadBalancingOptimizationStrategy loadBalance;
    private static int cycleCount = 0;

    public void addNewServer(Server server) {
        dataCenter.serverValidOrNullPointerExceptionThrow(server);
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenter.serverValidOrNullPointerExceptionThrow(server);
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
        int numberOfServers = dataCenter.getServers().size();
        for (int i = 0; i < numberOfServers; i++) {
            if (dataCenter.getNextServer().allocateLoad(resourceRequest.load())) {
                return;
            }
        }
        if (cycleCount < LIMIT_OF_OPTIMIZATION_ATTEMPT) {
            cycleCount++;
            loadBalance.optimize(dataCenter);
            allocateResources(resourceRequest);
        } else {
            cycleCount = 0;
            optimizationAttemptsLimitExceededExceptionThrow(LIMIT_OF_OPTIMIZATION_ATTEMPT);
        }
    }

    public void releaseResources(ResourceRequest resourceRequest) {
        int numberOfServers = dataCenter.getServers().size();
        for (int i = 0; i < numberOfServers; i++) {
            if (dataCenter.getNextServer().releaseLoad(resourceRequest.load())) {
                return;
            }
        }
        if (cycleCount < LIMIT_OF_OPTIMIZATION_ATTEMPT) {
            cycleCount++;
            loadBalance.optimize(dataCenter);
            releaseResources(resourceRequest);
        } else {
            cycleCount = 0;
            optimizationAttemptsLimitExceededExceptionThrow(LIMIT_OF_OPTIMIZATION_ATTEMPT);
        }
    }

    private void optimizationAttemptsLimitExceededExceptionThrow(int limit) {
        throw new RuntimeException("Превышен лимит в %d попыток оптимизации".formatted(limit));
    }
}
