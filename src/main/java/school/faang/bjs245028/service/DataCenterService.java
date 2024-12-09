package school.faang.bjs245028.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import school.faang.bjs245028.balancer.OptimizationStrategy;
import school.faang.bjs245028.model.DataCenter;
import school.faang.bjs245028.model.ResourceRequest;
import school.faang.bjs245028.model.Server;

@RequiredArgsConstructor
public class DataCenterService implements DataCenterProvider, OptimizationStrategy {

    private final DataCenter dataCenter;
    private final OptimizationStrategy optimizationStrategy;

    @Override
    public void addServer(Server server) {
        validate(server);
        dataCenter.getServers().add(server);
    }

    @Override
    public void removeServer(Server server) {
        validate(server);
        dataCenter.getServers().remove(server);
    }

    @Override
    public double getTotalEnergyConsumption() {
        return dataCenter.getServers()
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    @Override
    public void allocateResources(ResourceRequest request) {
        double remainingLoad = request.load();
        for (Server server : dataCenter.getServers()) {
            double availableCapacity = server.getMaxLoad() - server.getLoad();
            if (availableCapacity > 0) {
                double allocatedLoad = Math.min(remainingLoad, availableCapacity);
                server.setLoad(server.getLoad() + allocatedLoad);
                remainingLoad -= allocatedLoad;

                if (remainingLoad <= 0) {
                    break;
                }
            }
        }

        if (remainingLoad > 0) {
            throw new IllegalArgumentException("Недостаточно доступных ресурсов. Нагрузка: " + remainingLoad
            );
        }
    }

    @Override
    public void releaseResources(ResourceRequest request) {
        double remainingLoad = request.load();
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() > 0) {
                double releasedLoad = Math.min(remainingLoad, server.getLoad());
                server.setLoad(server.getLoad() - releasedLoad);
                remainingLoad -= releasedLoad;

                if (releasedLoad <= 0) {
                    break;
                }
            }
        }

        if (remainingLoad > 0) {
            throw new IllegalArgumentException("Недостаточно полезной нагрузки для выпуска. Нагрузка:" + remainingLoad);
        }
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        optimizationStrategy.optimize(dataCenter);
    }

    private void validate(Server server) {
        if (server == null) {
            throw new IllegalArgumentException("Server must be not null");
        }
    }
}