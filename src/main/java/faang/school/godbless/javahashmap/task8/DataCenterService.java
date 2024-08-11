package faang.school.godbless.javahashmap.task8;

public class DataCenterService {
    DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public void allocateResources(ResourceRequest request) {

        Server leastLoadServer = dataCenter.getLeastLoadServer();
        if (leastLoadServer != null) {
            if (request.getLoad() <= leastLoadServer.getMaxLoad() - leastLoadServer.getLoad()) {
                leastLoadServer.setLoad(leastLoadServer.getLoad() + request.getLoad());
            } else {
                System.out.println("Не хватает ресурсов на сервере");
            }
        } else {
            System.out.println("Нет доступных серверов");
        }
    }

    public void releaseResources(ResourceRequest request) {
        Server mostLoadServer = dataCenter.getMostLoadServer();
        if (mostLoadServer != null) {
            mostLoadServer.setLoad(mostLoadServer.getLoad() - request.getLoad());
        }
    }

    public void optimize(OptimizationStrategy optimizationStrategy) {
        optimizationStrategy.optimize(dataCenter);
    }
}
