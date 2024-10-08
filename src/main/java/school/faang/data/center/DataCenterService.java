package school.faang.data.center;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
public class DataCenterService {
    private static final double LOAD_BUFFER = 300;
    private static final double STANDARD_ENERGY_CONSUMPTION = 25;

    private final OptimizationStrategy optimizationStrategy;

    public void add(@NonNull Server server, DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        servers.add(server);
        dataCenter.setServers(servers);
        optimizationStrategy.optimize(dataCenter);
    }

    public void remove(@NonNull Server server, DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        servers.remove(server);
        dataCenter.setServers(servers);
        optimizationStrategy.optimize(dataCenter);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalEnergyConsumption = 0;
        for (Server server : servers) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public void allocateResources(@NonNull ResourceRequest request, DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double requestLoad = request.getLoad();
        for (Server server : servers) {
            if (server.loadAbility(requestLoad)) {
                server.setLoad(requestLoad + server.getLoad());
                dataCenter.setServers(servers);
                optimizationStrategy.optimize(dataCenter);
                return;
            }
        }
        servers.add(new Server(requestLoad, requestLoad + LOAD_BUFFER, STANDARD_ENERGY_CONSUMPTION));
        dataCenter.setServers(servers);
        optimizationStrategy.optimize(dataCenter);
    }

    public void releaseResources(@NonNull ResourceRequest request, DataCenter dataCenter) {
        List<Server> serves = dataCenter.getServers();
        double requestLoad = request.getLoad();
        for (Server server : serves) {
            if (server.getLoad() >= requestLoad) {
                server.setLoad(server.getLoad() - requestLoad);
                break;
            } else {
                requestLoad -= server.getLoad();
                server.setLoad(0);
            }
        }
        dataCenter.setServers(serves);
        optimizationStrategy.optimize(dataCenter);
    }

    public void printReport(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        for (int i = 0; i < servers.size(); i++) {
            System.out.println("server " + i + ": " + servers.get(i));
        }
        System.out.println(getTotalEnergyConsumption(dataCenter));
    }
}
