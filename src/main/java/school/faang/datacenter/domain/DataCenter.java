package school.faang.datacenter.domain;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 06.06.2025
 */
public class DataCenter {

    @Getter
    private final List<Server> servers = new ArrayList<>();

    private double maxLoad = 0;
    @Getter
    private double currentLoad = 0;

    public void addServer(@NonNull Server server) {
        servers.add(server);
        maxLoad += server.getMaxLoad();
        System.out.println("Server added: " + server);
    }

    public void removeServer(@NonNull Server server) {
        if (server.getLoad() != 0) {
            System.out.printf("Can't remove server %s%n", server);
            return;
        }
        var removed = servers.remove(server);
        if (removed) {
            maxLoad -= server.getMaxLoad();
            currentLoad -= server.getLoad();
            System.out.println("Server removed: " + server);
        }
    }

    public double getTotalEnergyConsumption() {
        return servers.stream()
                .map(Server::getEnergyConsumption)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    public boolean allocateResources(@NonNull ResourceRequest request) {
        var requestedLoad = request.load();
        var availableLoad = maxLoad - currentLoad;
        if (requestedLoad > availableLoad) {
            System.out.printf("Can't allocate resource %s%n", request);
            return false;
        }
        for (var server : servers) {
            if (requestedLoad == 0) {
                break;
            }
            var resourceToAllocate = server.getMaxLoad() - server.getLoad();
            requestedLoad -= resourceToAllocate;
            server.setLoad(resourceToAllocate);
        }
        currentLoad += request.load();
        System.out.println("Resource allocated: " + request);
        return true;
    }

    public void releaseResources(@NonNull ResourceRequest request) {
        var requestedLoad = request.load();
        if (currentLoad < requestedLoad) {
            System.out.printf("Can't release resource %s%n", request);
            return;
        }
        for (var server : servers) {
            var resourcePerServer = requestedLoad / servers.size();
            server.setLoad(server.getLoad() - resourcePerServer);
        }
        currentLoad -= requestedLoad;
        System.out.println("Resource released: " + request);
    }
}
