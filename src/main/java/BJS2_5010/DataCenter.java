package BJS2_5010;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private List<Server> servers = new ArrayList<>();

    public Server findLowLoadServer(ResourceRequest request) {
        double lowLoadServer = 0;
        Server availableServer = null;
        for (Server server : servers) {
            if (server.getLoad() + request.getLoad() <= server.getMaxLoad() && lowLoadServer <= server.getLoad()) {
                availableServer = server;
                lowLoadServer = server.getLoad();
            }
        }
        return availableServer;
    }

    public double getTotalEnergyConsumption() {
        return servers.stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public void deleteServer(Server server) {
        if (server.getLoad() != 0) {
            System.out.println("Этот сервер еще не выполнил процессы");
        } else {
            servers.remove(server);
        }
    }

    public void addServer(Server server) {
        servers.add(server);
    }
}
