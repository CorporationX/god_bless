package school.faang.data.center;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private static final double LOAD_BUFFER = 300;
    private static final double STANDARD_ENERGY_CONSUMPTION = 25;

    private final List<Server> servers = new ArrayList<>();

    public List<Server> getServers() {
        return new ArrayList<>(servers);
    }

    public void add(Server server) {
        servers.add(server);
    }

    public void remove(Server server) {
        servers.remove(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : servers) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public void allocateResources(ResourceRequest request) {
        double requestLoad = request.getLoad();
        for (Server server : servers) {
            if (server.loadAbility(requestLoad)) {
                server.setLoad(requestLoad + server.getLoad());
                return;
            }
        }
        servers.add(new Server(requestLoad, requestLoad + LOAD_BUFFER, STANDARD_ENERGY_CONSUMPTION));
    }

    public void releaseResources(ResourceRequest request) {
        double requestLoad = request.getLoad();
        for (Server server : servers) {
            if (server.getLoad() >= requestLoad) {
                server.setLoad(server.getLoad() - requestLoad);
                break;
            } else {
                requestLoad -= server.getLoad();
                server.setLoad(0);
            }
        }
    }

    public void printReport() {
        for (int i = 0; i < servers.size(); i++) {
            System.out.println("server " + i + ": " + servers.get(i));
        }
        System.out.println(getTotalEnergyConsumption());
    }
}
