package faang.school.godbless.BJS2_4135.services;

import faang.school.godbless.BJS2_4135.models.DataCenter;
import faang.school.godbless.BJS2_4135.models.ResourceRequest;
import faang.school.godbless.BJS2_4135.models.Server;
import faang.school.godbless.BJS2_4135.optimizators.OptimizationStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public double getTotalLoad() {
        return dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
    }

    public void allocateResources(ResourceRequest request) {
        double remainingLoad = request.getLoad();

        for (Server server : dataCenter.getServers()) {
            if (remainingLoad <= 0) {
                break;
            }

            double availableCapacity = server.getMaxLoad() - server.getLoad();

            if (availableCapacity > 0) {
                double loadToAllocate = Math.min(remainingLoad, availableCapacity);
                server.allocate(loadToAllocate);
                remainingLoad -= loadToAllocate;
            }
        }

        if (remainingLoad > 0) {
            throw new RuntimeException("Нет достаточно доступного сервера для распределения запрошенной нагрузки, осталось нераспределенной: " + remainingLoad);
        }
    }

    public void releaseResources(ResourceRequest request) {
        double totalLoad = getTotalLoad();
        if (totalLoad == 0) {
            return;
        }

        double resourcesToRelease = request.getLoad();

        for (Server server : dataCenter.getServers()) {
            double currentLoad = server.getLoad();
            if (currentLoad == 0) {
                continue; // Пропускаем серверы с нулевой загрузкой
            }
            double loadToRelease = Math.min(currentLoad, resourcesToRelease); // Определяем, сколько загрузки нужно освободить на этом сервере
            server.release(loadToRelease); // Освобождаем загрузку на сервере
            resourcesToRelease -= loadToRelease; // Уменьшаем количество освобождаемых ресурсов
        }
    }

    public void optimizeResources() {
        optimizationStrategy.optimize(dataCenter);
    }
}