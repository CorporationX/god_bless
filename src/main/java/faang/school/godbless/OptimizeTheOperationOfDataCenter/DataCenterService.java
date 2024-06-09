package faang.school.godbless.OptimizeTheOperationOfDataCenter;

public class DataCenterService implements OptimizationStrategy {
    private static final int HIGHEST_PERCENTAGE = 90;

    public void addServer(DataCenter dataCent, Server server) {
        dataCent.getServers().add(server);
    }

    public void deleteServer(DataCenter dataCent, Server server) {
        dataCent.getServers().remove(server);
    }


    public int getTotalEnergyConsumption(DataCenter dataCent) {
        int sumTotalEnergyConsumption = 0;
        for (Server server : dataCent.getServers()) {
            sumTotalEnergyConsumption += server.getEnergyConsumption();
        }
        return sumTotalEnergyConsumption;
    }

    public void allocateResources(ResourceRequest request, DataCenter dataCent) {
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

    public void releaseResources(ResourceRequest request, DataCenter dataCent) {
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
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        double allLoad = 0;
        for (Server server : dataCenter.getServers()) {
            allLoad += server.getLoad();
        }
        for (Server server : dataCenter.getServers()) {
            server.setLoad(allLoad / dataCenter.getServers().size());
        }
    }
}
