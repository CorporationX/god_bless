package faang.school.godbless.datacenter.services;

import faang.school.godbless.datacenter.models.Server;

import java.util.ArrayList;
import java.util.List;

public class ServerService {

    private static final int ZERO = 0;
    private static final int HUNDRED = 100;

    public static Server createNewServer() {
        return new Server(ZERO);
    }

    public static double getEnergyConsumptionOnServers(List<Server> servers) {
        return servers.stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public static double getTotalLoadOnServers(List<Server> servers) {
        return servers.stream()
                .mapToDouble(Server::getLoad)
                .sum();
    }

    public static void allocateResourcesInServers(List<Server> servers, double requestedLoad) {
        final double[] currentNeededAddLoad = {requestedLoad};

        servers.stream()
                .filter(server -> (server.getMaxLoad() - server.getLoad() > 0))
                .forEach(server -> {
                    if (currentNeededAddLoad[0] > 0) {
                        double emptyLoadOnServer = server.getMaxLoad() - server.getLoad();
                        if (emptyLoadOnServer > currentNeededAddLoad[0]) {
                            emptyLoadOnServer = currentNeededAddLoad[0];
                        }
                        server.setLoad(server.getLoad() + emptyLoadOnServer);
                        server.setEnergyConsumption(server.getEnergyConsumption() + emptyLoadOnServer);
                        currentNeededAddLoad[0] -= emptyLoadOnServer;
                    }
                });

        if (currentNeededAddLoad[0] > 0) {
            addRequestedLoadInServers(servers, currentNeededAddLoad[0]);
        }
    }


    public static void releaseResourcesInServers(List<Server> servers, double requestedRelease) {
        final double[] currentNeededRemoveLoad = {requestedRelease};

        servers.stream()
                .filter(server -> (server.getLoad() >= ZERO))
                .forEach(server -> {
                    if (currentNeededRemoveLoad[0] > 0) {
                        double busyLoadOnServer = server.getLoad();
                        if (busyLoadOnServer > currentNeededRemoveLoad[0]) {
                            busyLoadOnServer = currentNeededRemoveLoad[0];
                        }
                        server.setLoad(server.getLoad() - busyLoadOnServer);
                        server.setEnergyConsumption(server.getEnergyConsumption() - busyLoadOnServer);
                        currentNeededRemoveLoad[0] -= busyLoadOnServer;
                    }
                });
    }

    private static void addRequestedLoadInServers(List<Server> servers, double request) {
        if (request > ZERO) {
            ArrayList<Server> newServers = new ArrayList<>();

            while (request > ZERO) {
                if (request > HUNDRED) {
                    newServers.add(new Server(HUNDRED));
                    request -= HUNDRED;
                } else {
                    newServers.add(new Server(request));
                    request -= request;
                }
            }
            servers.addAll(newServers);
        }
    }
}
