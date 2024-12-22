package school.faang.bjs245016;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.UUID;

public class DataCenterService {
    private DataCenter datacenter = new DataCenter();
    private OptimizationStrategy strategy;

    public DataCenterService(OptimizationStrategy strategy) {
        this.strategy = strategy;
    }

    public void addServer(String name, double load, double maxLoad, double energyConsumption) {
        Server server = new Server(UUID.randomUUID(), name, load, maxLoad, energyConsumption);
        datacenter.getServersList().add(server);
    }

    public void removeServer(UUID serverId) {
        datacenter.getServersList().removeIf(server -> Objects.equals(server.getId(), serverId));
    }

    public double getTotalEnergyConsumption() {
        return datacenter.getServersList().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(ResourceRequest request) {
        Server server = datacenter.getServersList().stream()
                .filter(s -> s.getMaxLoad() - s.getLoad() > request.getLoad())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No server found with enough resources"));

        server.setLoad(server.getLoad() + request.getLoad());
        request.setServerId(server.getId());
    }

    public void releaseResources(ResourceRequest request) {
        datacenter.getServersList().stream()
                .filter(server -> server.getId().equals(request.getServerId()))
                .findFirst()
                .ifPresent(server -> server.setLoad(server.getLoad() - request.getLoad()));
    }

    public void optimizeDatacenter() {
        strategy.optimize(datacenter);
    }
}
