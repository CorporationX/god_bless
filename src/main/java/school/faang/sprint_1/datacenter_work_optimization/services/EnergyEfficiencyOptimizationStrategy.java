package school.faang.sprint_1.datacenter_work_optimization.services;

import school.faang.sprint_1.datacenter_work_optimization.model.DataCenter;
import school.faang.sprint_1.datacenter_work_optimization.model.Server;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        AtomicReference<Double> remainingLoad = new AtomicReference<>(dataCenter.calculateTotalLoad());

        dataCenter.getServers().forEach(server -> server.setLoad(0));

        dataCenter.getServers().stream()
                .sorted(Comparator.comparingDouble(Server::getEfficiency))
                .filter(server -> server.getMaxLoad() > 0)
                .takeWhile(server -> remainingLoad.get() > 0)
                .forEach(server -> {
                    double toAssign = Math.min(remainingLoad.get(), server.getMaxLoad());
                    server.setLoad(toAssign);
                    remainingLoad.updateAndGet(load -> load - toAssign);
                });
        dataCenter.getServers().removeIf(server -> server.getLoad() == 0);

    }
}
