package school.faang.datacenter.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class DataCenter {
    private final List<Server> servers;

    public Server addServer(Server server) {
        servers.add(server);
        return server;
    }

    public boolean removeServer(Server server) {
        return servers.remove(server);
    }

    public double getTotalEnergyConsumption() {
        return servers.stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void releaseResources(ResourceRequest request) {
        double loadToRemain = request.getLoad();
        for (Server server : servers) {
            if (server.getLoad() > loadToRemain) {
                server.setLoad(server.getLoad() - loadToRemain);
                break;
            } else {
                loadToRemain -= server.getLoad();
                server.setLoad(0);
            }
        }
    }

    public boolean allocateResources(ResourceRequest request) {
        double remainingLoad = request.getLoad();
        for (Server server : servers) {
            double remainingOnServer = server.getMaxLoad() - server.getLoad();
            if (remainingOnServer >= remainingLoad) {
                server.setLoad(remainingOnServer - remainingLoad + server.getLoad());
                remainingLoad = 0;
                break;
            } else {
                remainingLoad -= server.getMaxLoad() - server.getLoad();
                server.setLoad(server.getMaxLoad());
            }
        }
        return remainingLoad == 0;
    }
}