package faang.school.godbless;

import java.util.Map;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy{
    @Override
    public void optimize(DataCenter datacenter) {
        double totalUsed = 0;
        double totalMax = 0;
        for (Map.Entry<String, Server> entry : datacenter.servers.entrySet()) {
            totalUsed = totalUsed + entry.getValue().getLoad();
            totalMax = totalMax + entry.getValue().getMaxLoad();
        }
        double busyCoeff = totalUsed / totalMax;
        for (Map.Entry<String, Server> entry : datacenter.servers.entrySet()) {
            double deltaLoad = busyCoeff*entry.getValue().getMaxLoad() - entry.getValue().getLoad();
            entry.getValue().setLoad(busyCoeff*entry.getValue().getMaxLoad());
            entry.getValue().setEnergyConsumption(entry.getValue().getEnergyConsumption()+3*deltaLoad);
        }
    }
}
