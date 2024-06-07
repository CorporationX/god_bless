package faang.school.godbless.OptimizeTheOperationOfDataCenter;

import lombok.Data;


public class DataCenterService {
    private static final int HIGHEST_PERCENTAGE = 90;
    DataCenter dataCent;


    public void addServer(Server server) {
        dataCent.getServers().add(server);
    }

    public void deleteServer(Server server) {
        dataCent.getServers().remove(server);
    }

    ;

    public int getTotalEnergyConsumption() {
        int sumTotalEnergyConsumption = 0;
        for (Server server : dataCent.getServers()) {
            sumTotalEnergyConsumption += server.getEnergyConsumption();
        }
        return sumTotalEnergyConsumption;
    }


    public void allocateResources(ResourceRequest request) {
        double requestLoad = request.getLoad();
        for (Server server : dataCent.getServers()) {
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


    public void releaseResources(ResourceRequest request) {
        double requestLoad = request.getLoad();
        for (Server server : dataCent.getServers()) {
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
