package faang.school.godbless.task.hashmap.data.center.optimization;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DataCenterService {
    private static final int LIMIT_OF_OPTIMIZATION_ATTEMPT = 5;

    @Getter
    private final DataCenter dataCenter;
    private final LoadBalancingOptimizationStrategy loadBalance;
    private static int cycleCount = 0;

    public void addNewServer(@NonNull Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(@NonNull Server server) {
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption() {
        double energyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            energyConsumption += server.getEnergyConsumption();
        }
        return energyConsumption;
    }

    public void allocateResources(@NonNull ResourceRequest resourceRequest) {
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
            System.out.println("Превышен лимит в %d попыток оптимизации"
                    .formatted(LIMIT_OF_OPTIMIZATION_ATTEMPT));
        }
    }

    public void releaseResources(@NonNull ResourceRequest resourceRequest) {
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
            System.out.println("Превышен лимит в %d попыток оптимизации"
                    .formatted(LIMIT_OF_OPTIMIZATION_ATTEMPT));
        }
    }
}

