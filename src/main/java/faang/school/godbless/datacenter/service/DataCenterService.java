package faang.school.godbless.datacenter.service;

import faang.school.godbless.datacenter.model.DataCenter;
import faang.school.godbless.datacenter.model.OptimizationOperation;
import faang.school.godbless.datacenter.model.ResourceRequest;
import faang.school.godbless.datacenter.model.Server;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.Optional;

@Data
@AllArgsConstructor
public class DataCenterService {

    private final DataCenter dataCenter;

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void deleteServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers()
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(ResourceRequest resourceRequest) {
        Optional<Server> leastLoadedServer = dataCenter.getServers()
                .stream()
                .min(Comparator.comparingDouble(Server::getLoad));
        if (leastLoadedServer.isPresent()) {
            Server server = leastLoadedServer.get();
            server.regulateLoad(resourceRequest.load(), OptimizationOperation.INCREASE);
        }
    }

    public void releaseResources(ResourceRequest resourceRequest) {
        Optional<Server> maxLoadedServer = dataCenter.getServers()
                .stream()
                .max(Comparator.comparingDouble(Server::getLoad));
        if (maxLoadedServer.isPresent()) {
            Server server = maxLoadedServer.get();
            server.regulateLoad(resourceRequest.load(), OptimizationOperation.DECREASE);
        }
    }
}
