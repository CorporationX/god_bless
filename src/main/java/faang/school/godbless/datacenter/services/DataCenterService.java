package faang.school.godbless.datacenter.services;

import faang.school.godbless.datacenter.entities.DataCenter;
import faang.school.godbless.datacenter.entities.ResourceRequest;
import faang.school.godbless.datacenter.entities.Server;
import faang.school.godbless.datacenter.exceptions.ResourceAllocateException;
import faang.school.godbless.datacenter.exceptions.ResourceReleaseExceptions;
import faang.school.godbless.datacenter.optimization.OptimizationStrategy;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static java.util.Comparator.comparing;

@RequiredArgsConstructor
public class DataCenterService {
    private final DataCenter dataCenter;

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        if (!dataCenter.getServers().remove(server)) {
            throw new NoSuchElementException("Server not found in data center");
        }
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers()
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(ResourceRequest request) {
        var requestLoad = request.getLoad();
        var maxAvailableServerLoad = findMaxServer(comparing(DataCenterService::getAvailableLoad));

        if (maxAvailableServerLoad == null || getAvailableLoad(maxAvailableServerLoad) < requestLoad) {
            throw new ResourceAllocateException("There is no available servers to allocate these resources");
        } else {
            maxAvailableServerLoad.setLoad(maxAvailableServerLoad.getLoad() + requestLoad);
        }
    }

    public void releaseResources(ResourceRequest request) {
        var requestLoad = request.getLoad();
        var maxServerLoad = findMaxServer(comparing(Server::getLoad));

        if (maxServerLoad == null || maxServerLoad.getMaxLoad() < requestLoad) {
            throw new ResourceReleaseExceptions("There is no available servers to release these resources");
        } else if (maxServerLoad.getLoad() < requestLoad) {
            maxServerLoad.setLoad(0);
        } else {
            maxServerLoad.setLoad(maxServerLoad.getLoad() - requestLoad);
        }
    }

    public void optimizeDataCenter(OptimizationStrategy optimizationStrategy) {
        optimizationStrategy.optimize(dataCenter);
    }

    private Server findMaxServer(Comparator<Server> comparator) {
        return dataCenter.getServers()
                .stream()
                .max(comparator)
                .orElse(null);
    }

    private static Double getAvailableLoad(Server server) {
        return server.getMaxLoad() - server.getLoad();
    }
}
