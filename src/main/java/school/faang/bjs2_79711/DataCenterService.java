package school.faang.bjs2_79711;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_79711.strategy.OptimizationStrategy;

@Slf4j
public class DataCenterService {
    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergyConsumption = 0;

        totalEnergyConsumption =
                dataCenter.getServers().stream().mapToDouble(Server::getEnergyConsumption).sum();

        return totalEnergyConsumption;
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double requestLoad = request.load();

        for (Server server : dataCenter.getServers()) {
            double serverMaxLoad = server.getMaxLoad();
            double serverLoad = server.getLoad();

            if (serverLoad != serverMaxLoad) {
                double remainsLoad = (serverMaxLoad - serverLoad) - requestLoad;
                if (remainsLoad < 0) {
                    server.setLoad(serverMaxLoad);
                    requestLoad = Math.abs(remainsLoad);
                } else {
                    server.setLoad(serverLoad + requestLoad);
                    return true;
                }
            }
        }
        return false;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double requestLoad = request.load();

        for (Server server : dataCenter.getServers()) {
            double serverLoad = server.getLoad();
            if (serverLoad != 0) {
                double notReleasedLoad = serverLoad - requestLoad;
                if (notReleasedLoad < 0) {
                    server.setLoad(0);
                    requestLoad = Math.abs(notReleasedLoad);
                } else {
                    server.setLoad(serverLoad - requestLoad);
                    break;
                }
            }
        }
    }

    public void optimizeLoad(DataCenter dataCenter, OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }
}
