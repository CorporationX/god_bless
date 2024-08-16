package faang.school.godbless.datacenter.models;

import faang.school.godbless.datacenter.services.OptimizationStrategy;
import lombok.NoArgsConstructor;

import static faang.school.godbless.datacenter.services.DataCenterService.getTotalLoadOnAllServers;

@NoArgsConstructor
public class DataCenterMiddleOptimization implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        double commonLoad = getTotalLoadOnAllServers(dataCenter);
        double optimizeLoad = commonLoad / dataCenter.getServers().size();

        for (Server server : dataCenter.getServers()) {
            double serverLoad = server.getLoad();
            if (serverLoad > optimizeLoad) {
                double differenceIdLoad = serverLoad - optimizeLoad;
                server.setLoad(optimizeLoad);
                server.setEnergyConsumption(server.getEnergyConsumption() - differenceIdLoad);
            } else if (serverLoad < optimizeLoad) {
                double differenceIdLoad = optimizeLoad - serverLoad;
                server.setLoad(optimizeLoad);
                server.setEnergyConsumption(server.getEnergyConsumption() + differenceIdLoad);
            }
        }
    }
}
