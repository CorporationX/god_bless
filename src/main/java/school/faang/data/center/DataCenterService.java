package school.faang.data.center;

import lombok.NonNull;

import java.util.List;

public class DataCenterService {
    private static final double LOAD_BUFFER = 300;
    private static final double STANDARD_ENERGY_CONSUMPTION = 25;

    private final DataCenter dataCenter;
    private final OptimizationStrategy optimizationStrategy;

    public DataCenterService(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        this.dataCenter = dataCenter;
        this.optimizationStrategy = optimizationStrategy;
    }

    public void add(@NonNull Server server) {
        dataCenter.getServers().add(server);
        optimizationStrategy.optimize(dataCenter);
    }

    public void remove(@NonNull Server server) {
        dataCenter.getServers().remove(server);
        optimizationStrategy.optimize(dataCenter);
    }

    public double getTotalEnergyConsumption() {
        List<Server> servers = dataCenter.getServers();
        double totalEnergyConsumption = 0;
        for (Server server : servers) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public void allocateResources(@NonNull ResourceRequest request) {
        List<Server> servers = dataCenter.getServers();
        double requestLoad = request.getLoad();
        for (Server server : servers) {
            if (server.loadAbility(requestLoad)) {
                server.setLoad(requestLoad + server.getLoad());
                optimizationStrategy.optimize(dataCenter);
                return;
            }
        }
        servers.add(new Server(requestLoad, requestLoad + LOAD_BUFFER, STANDARD_ENERGY_CONSUMPTION));
        optimizationStrategy.optimize(dataCenter);
    }

    public void releaseResources(@NonNull ResourceRequest request) {
        List<Server> serves = dataCenter.getServers();
        double requestLoad = request.getLoad();
        for (Server server : serves) {
            if (server.getLoad() >= requestLoad) {
                server.setLoad(server.getLoad() - requestLoad);
                break;
            } else if (server.getLoad() < requestLoad) {
                requestLoad -= server.getLoad();
                server.setLoad(0);
            }
        }
        optimizationStrategy.optimize(dataCenter);
    }

    public void printReport() {
        List<Server> servers = dataCenter.getServers();
        for (int i = 0; i < servers.size(); i++) {
            System.out.println("server " + i + ": " + servers.get(i));
        }
        System.out.println(getTotalEnergyConsumption());
    }
}
