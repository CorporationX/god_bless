package faang.school.godbless.BJS2_19396;

import java.util.Random;

public class DataCenterService {

    public static void addServer(DataCenter dataCenter, Server server) {
        dataCenter.addServer(server);
    }

    public static void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.removeServer(server);
    }

    public static void allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double requestLoad = request.getLoad(),
                maxLoadForServer = 1000;
        EnergyConsumptionService energyService = new EnergyConsumptionService(new Random());

        for (int i = dataCenter.size() - 1; requestLoad > 1000; i++) {
            Server server = dataCenter.getServer(i);
            double freeLoad = maxLoadForServer - server.getLoad();
            server.addLoad(freeLoad);
            requestLoad -= freeLoad;
            dataCenter.addServer(new Server(0, energyService));
        }

        Server server = dataCenter.getServer(dataCenter.size() - 1);
        server.addLoad(requestLoad);
    }

    public static void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double requestLoad = request.getLoad();
        if (requestLoad > dataCenter.getLoad()) {
            throw new IllegalArgumentException();
        }

        for (Server server : dataCenter.getServers()) {
            double load = server.getLoad();
            if (requestLoad >= load) {
                dataCenter.removeServer(server);
                requestLoad -= load;
            } else {
                server.removeLoad(requestLoad);
                return;
            }
        }
    }

    public static void optimization(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        optimizationStrategy.optimize(dataCenter);
    }
}
