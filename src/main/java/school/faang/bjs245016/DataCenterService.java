package school.faang.bjs245016;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.UUID;

public class DataCenterService {
    private DataCenter datacenter = new DataCenter();

    public void addServer(String name, double load, double maxLoad, double energyConsumption) {
        Server server = new Server(UUID.randomUUID(), name, load, maxLoad, energyConsumption);
        datacenter.getServersList().add(server);
    }

    public void removeServer(UUID serverId) {
        Iterator<Server> iterator = datacenter.getServersList().iterator();
        while (iterator.hasNext()) {
            Server server = iterator.next();
            if (server.getId().equals(serverId)) {
                iterator.remove();
                break;
            }
        }
    }

    public double getTotalEnergyConsumption() {
        return datacenter.getServersList().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(ResourceRequest request) {
        Server server = datacenter.getServersList().stream()
                .filter(s -> s.getMaxLoad() - s.getLoad() > s.getLoad())
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

    public void optimizeDatacenter(String strategyClassName) {
        try {
            Class<?> cl = Class.forName(Constants.CLASS_REFERECE + strategyClassName);
            OptimizationStrategy strategy = (OptimizationStrategy) cl.getDeclaredConstructor().newInstance();
            strategy.optimize(datacenter);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                 | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Failed to instantiate strategy: " + strategyClassName, e);
        }

    }
}
