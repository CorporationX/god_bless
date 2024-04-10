package faang.school.godbless.data_center;

import java.util.List;

public class DataCenterService {
    private DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void optimizeDataCenter() {
        EnergyEfficencyOptimizationStrategy optimizationStrategy =
                new EnergyEfficencyOptimizationStrategy(1800000, dataCenter);
        optimizationStrategy.optimize(dataCenter);
    }

    public void addServerToDataCenter(DataCenter dataCenter, Server server) {
        dataCenter.addServer(server);
    }

    public void removeServerFromDataCenter(DataCenter dataCenter, Server server) {
        dataCenter.removeServer(server);
    }

    public void getTotalEnergyConsumption(DataCenter dataCenter) {
        dataCenter.getTotalEnergy();
    }

    public void allocateResources(DataCenter dataCenter, ResourceRequest request) {
        List<Server> servers = dataCenter.getServers();
        if (servers.isEmpty()) {
            System.out.println("Нет серверов");
            return;
        }
        Server leastLoadedServer = servers.get(0);
        for (Server server : servers) {
            if (server.getLoad() < leastLoadedServer.getLoad()) {
                leastLoadedServer = server;
            }
        }
        double newLoad = leastLoadedServer.getLoad() + request.getLoad();
        if (newLoad > leastLoadedServer.getMaxLoad()) {
            System.out.println("Нагрузка сервера превышает максимальную нагрузку");
        } else {
            leastLoadedServer.setLoad(newLoad);
            System.out.println("Ресурсы выделены на сервер: " + leastLoadedServer);
        }
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        dataCenter.releaseResources(dataCenter, request);
    }
}

