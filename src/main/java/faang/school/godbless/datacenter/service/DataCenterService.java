package faang.school.godbless.datacenter.service;

import faang.school.godbless.datacenter.model.DataCenter;
import faang.school.godbless.datacenter.model.OptimizationOperation;
import faang.school.godbless.datacenter.model.ResourceRequest;
import faang.school.godbless.datacenter.model.Server;
import faang.school.godbless.datacenter.strategy.OptimizationStrategy;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Optional;

@Data
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataCenterService {

    final DataCenter dataCenter;
    OptimizationStrategy optimizationStrategy;

    public DataCenterService(@NonNull DataCenter dataCenter, @NonNull OptimizationStrategy optimizationStrategy) {
        this.dataCenter = dataCenter;
        this.optimizationStrategy = optimizationStrategy;
    }

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
        } else {
            log.warn("There appears to be no servers to allocate resources on.");
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
        } else {
            log.warn("There appears to be no servers to release resources from.");
        }
    }

    public void optimize(OptimizationStrategy strategy) {
        strategy.optimize(this.dataCenter);
    }
}
