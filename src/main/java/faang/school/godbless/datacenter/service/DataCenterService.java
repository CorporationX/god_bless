package faang.school.godbless.datacenter.service;

import faang.school.godbless.datacenter.model.DataCenter;
import faang.school.godbless.datacenter.model.OptimizationOperation;
import faang.school.godbless.datacenter.model.ResourceRequest;
import faang.school.godbless.datacenter.model.Server;

import java.util.Comparator;
import java.util.Optional;

public record DataCenterService(DataCenter dataCenter) {

    public void addServer(Server server) {
        if (server == null) {
            throw new IllegalArgumentException("Server must not be null");
        }
        dataCenter.servers().add(server);
    }

    public void deleteServer(Server server) {
        if (server == null) {
            throw new IllegalArgumentException("Server must not be null");
        }
        dataCenter.servers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.servers()
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(ResourceRequest resourceRequest) {
        if (resourceRequest == null) {
            throw new IllegalArgumentException("Requests for resources cannot be null");
        }
        Optional<Server> leastLoadedServer = dataCenter.servers()
                .stream()
                .min(Comparator.comparingDouble(Server::getLoad));
        if (leastLoadedServer.isPresent()) {
            Server server = leastLoadedServer.get();
            server.regulateLoad(resourceRequest.load(), OptimizationOperation.INCREASE);
        }
    }

    public void releaseResources(ResourceRequest resourceRequest) {
        if (resourceRequest == null) {
            throw new IllegalArgumentException("Requests for resources cannot be null");
        }
        Optional<Server> maxLoadedServer = dataCenter.servers()
                .stream()
                .max(Comparator.comparingDouble(Server::getLoad));
        if (maxLoadedServer.isPresent()) {
            Server server = maxLoadedServer.get();
            server.regulateLoad(resourceRequest.load(), OptimizationOperation.DECREASE);
        }
    }
}
