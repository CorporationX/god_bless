package faang.school.godbless.task.database.optimization;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
        double energyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            energyConsumption += server.getEnergyConsumption();
        }
        return energyConsumption;
    }

    public void allocateResources(ResourceRequest resourceRequest) {
        for (Server server : dataCenter.getServers()) {
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
        for (Server server : dataCenter.getServers()) {
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
