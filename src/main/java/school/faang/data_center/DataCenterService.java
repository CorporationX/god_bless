package school.faang.data_center;

import java.util.concurrent.atomic.AtomicReference;

public class DataCenterService {

    protected void addServerToDataCenter(Server server) {
        DataCenter.ALL_SERVERS.add(server);
    }

    protected void removeServerFromDataCenter(Server server) {
        DataCenter.ALL_SERVERS.remove(server);
    }

    protected double getTotalEnergyConsumption() {
        AtomicReference<Double> totalEnergy = new AtomicReference<>(0.0);
        DataCenter.ALL_SERVERS.forEach(server -> {
            totalEnergy.updateAndGet(atom -> (double) (atom + server.getEnergyConsumption()));
        });
        return totalEnergy.get();
    }

    protected void allocateResources(ResourceRequest request) {
        double resource = request.getLoad();
        int amount = DataCenter.ALL_SERVERS.size();
        double loadFromOneServer = resource/amount;
        for (Server server : DataCenter.ALL_SERVERS) {

        }
    }
}
