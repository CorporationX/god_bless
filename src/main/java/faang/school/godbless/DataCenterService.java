package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class DataCenterService {
    DataCenter dataCenter;
    OptimizationStrategy strategy;

    public void addServer(Server server) {
        dataCenter.getServerList().add(server);
    }

    public void deleteServer(Server server) {
        dataCenter.getServerList().remove(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getTotalEnergyConsumption();
    }

    public double getTotalCurrentLoad() {
        return dataCenter.getTotalCurrentLoad();
    }

    public double getTotalMaxLoad() {
        return dataCenter.getTotalMaxLoad();
    }

    public double getLoadCapacity() {
        return getTotalMaxLoad() - getTotalCurrentLoad();
    }

    public void allocateResources(ResourceRequest request) {
        if (getLoadCapacity() < request.getLoad()) {
            System.out.println("There is no spare capacity in the data center to allocate");
        } else {
            double loadForAllocate = request.getLoad();
            for (Server server : dataCenter.getServerList()) {
                if (server.getMaxLoad() - server.getLoad() >= loadForAllocate) {
                    server.setLoad(server.getLoad() + loadForAllocate);
                    return;
                } else {
                    loadForAllocate -= (server.getMaxLoad() - server.getLoad());
                    server.setLoad(server.getMaxLoad());
                }
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        if (request.getLoad() > getTotalMaxLoad()) {
            String message = String.format("Max Load of the Data Center: %1$, .2f", getTotalMaxLoad());
            System.out.println("It's impossible to realise requested resources:");
            System.out.println(message);
            return;
        }
        double requestedLoad = request.getLoad();
        for (Server server : dataCenter.getServerList()) {
            if (server.getLoad() < requestedLoad) {
                requestedLoad -= server.getLoad();
                server.setLoad(0d);
            } else {
                server.setLoad(server.getLoad() - requestedLoad);
                return;
            }
        }
    }
}
