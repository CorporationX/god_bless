package school.faang.datacenter;

import lombok.RequiredArgsConstructor;
import school.faang.datacenter.domain.DataCenter;
import school.faang.datacenter.domain.ResourceRequest;
import school.faang.datacenter.domain.Server;
import school.faang.datacenter.optimization.OptimizationStrategy;

import java.time.LocalTime;

/**
 * @author Danil Pudovkin
 * @since 06.06.2025
 */
@RequiredArgsConstructor
public class DataCenterService {

    private final OptimizationStrategy optimizationStrategy;
    private LocalTime lastOptimizationTime = LocalTime.now();

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getTotalEnergyConsumption();
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        return dataCenter.allocateResources(request);
    }

    void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        dataCenter.releaseResources(request);
    }

    public void optimize(DataCenter dataCenter) {
        if (lastOptimizationTime.plusMinutes(30).isAfter(LocalTime.now())) {
            optimizationStrategy.optimize(dataCenter);
            lastOptimizationTime = LocalTime.now();
        }
    }
}
