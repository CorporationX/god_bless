package school.faang.task_45023;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class DataCenterService {
    private final DataCenter dataCenter;
    private final OptimizationStrategy strategy;

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream()
                .map(Server::getEnergyConsumption)
                .reduce(0.0, Double::sum);
    }

    public boolean allocateResources(ResourceRequest request) {
        double remainedLoad = request.getLoad();

        for (var server : dataCenter.getServers()) {
            double availableLoad = server.getMaxLoad() - server.getLoad();

            if (availableLoad < remainedLoad) {
                server.setLoad(server.getLoad() + availableLoad);
                remainedLoad -= availableLoad;
            } else {
                server.setLoad(server.getLoad() + remainedLoad);
                return true;
            }
        }

        return false;
    }

    public void releaseResources(ResourceRequest request) {
        double releasingLoad = request.getLoad();

        for (var server : dataCenter.getServers()) {
            double load = server.getLoad();

            if (load < releasingLoad) {
                server.setLoad(0);
                releasingLoad -= load;
            } else {
                server.setLoad(load - releasingLoad);
                break;
            }
        }
    }

    public void optimizeLoad() {
        strategy.optimize(dataCenter);
    }
}
