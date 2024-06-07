package faang.school.godbless.OptimizeTheOperationOfDataCenter;


import java.util.List;

public class DataCenter extends DataCenterService {
    private static final int HIGHEST_PERCENTAGE = 90;
    private List<Server> servers;

    public DataCenter(List<Server> servers) {
        this.servers = servers;
    }

    @Override
    void addServer(Server server) {
        this.servers.add(server);
    }

    @Override
    void deleteServer(Server server) {
        this.servers.remove(server);
    }

    @Override
    int getTotalEnergyConsumption() {
        int sumTotalEnergyConsumption = 0;
        for (Server server : servers) {
            sumTotalEnergyConsumption += server.getEnergyConsumption();
        }
        return sumTotalEnergyConsumption;

    }

    @Override
    void allocateResources(ResourceRequest request) {
        double requestLoad = request.getLoad();
        for (Server server : servers) {
            double loadPercent = server.getLoad() * 100 / server.getMaxLoad();
            if (loadPercent < HIGHEST_PERCENTAGE) {
                double difference = server.getMaxLoad() - (server.getMaxLoad() * 0.1) - server.getLoad();
                if (requestLoad > difference) {
                    server.setLoad(server.getLoad() + difference);
                    requestLoad -= difference;
                } else {
                    server.setLoad(server.getLoad() + requestLoad);
                    break;
                }
            }
        }
    }

    @Override
    void releaseResources(ResourceRequest request) {
        double requestLoad = request.getLoad();
        for (Server server : servers) {
            if (requestLoad > server.getLoad()) {
                requestLoad -= server.getLoad();
                server.setLoad(0.0);
            } else {
                server.setLoad(server.getLoad() - requestLoad);
                requestLoad = 0;
                break;
            }
        }
        if (requestLoad > 0) {
            requestLoad = 0;
        }
    }
}
