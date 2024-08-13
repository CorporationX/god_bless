package faang.school.godbless.bjs2_19287;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import static faang.school.godbless.bjs2_19287.Constants.CUSTOM_MAX_LOAD_COEFFICIENT;
import static faang.school.godbless.bjs2_19287.Constants.DEFAULT_MAX_LOAD;

public class DataCenter {
    @Getter
    private final List<Server> servers;

    private static DataCenter instance;

    private DataCenter() {
        servers = new ArrayList<>();
    }

    public static DataCenter getInstance() {
        if (instance == null) {
            instance = new DataCenter();
        }
        return instance;
    }

    public void addServer() {
        var newServer = new Server(false);
        servers.add(newServer);
    }

    public void addServerWithCustomMaxLoad(double maxLoad) {
        var newServer = new Server(false);
        newServer.setMaxLoad(maxLoad);
        servers.add(newServer);
    }

    public void addServerAndTurnOn() {
        var newServer = new Server(true);
        servers.add(newServer);
    }

    public void addServerWithLoadAndTurnOn(double load) {
        var newServer = new Server(true);
        newServer.increaseLoad(load);
        servers.add(newServer);
    }

    public void addServerWithCustomMaxLoadWithLoadAndTurnOn(double load) {
        var newServer = new Server(true);
        newServer.setMaxLoad(defineCustomMaxLoad(load));
        newServer.increaseLoad(load);
        servers.add(newServer);
    }

    private double defineCustomMaxLoad(double load) {
        return load * CUSTOM_MAX_LOAD_COEFFICIENT;
    }

    public void allocateLoad(double requestedLoad) {
        var requestNotWasProcessed = new AtomicBoolean(false);
        getAllActiveServersStream()
                .filter(server -> {
                    var currentLoad = server.getLoad();
                    var newLoad = currentLoad + requestedLoad;
                    return newLoad <= server.getMaxLoad();
                })
                .findFirst()
                .ifPresentOrElse(
                        server -> {
                            server.increaseLoad(requestedLoad);
                        },
                        () -> {
                            requestNotWasProcessed.set(true);
                        });
        if (requestNotWasProcessed.get()) {
            getAllInActiveServersStream()
                    .filter(server -> server.getMaxLoad() >= requestedLoad)
                    .findFirst()
                    .ifPresentOrElse(
                            server -> {
                                server.turnOn();
                                server.increaseLoad(requestedLoad);
                            },
                            () -> {
                                if (requestedLoad <= DEFAULT_MAX_LOAD) {
                                    addServerWithLoadAndTurnOn(requestedLoad);
                                } else {
                                    addServerWithCustomMaxLoadWithLoadAndTurnOn(requestedLoad); // or add some default servers
                                }
                            }
                    );
        }
    }

    public void releaseLoad(double releasedLoad) {
        double remainingLoad = releasedLoad;
        var activeServers = getAllActiveServersStream().toList();
        var size = activeServers.size() - 1;
        int i = 0;
        while (remainingLoad > 0 || i <= size) {
            var server = activeServers.get(i);
            var currentLoad = server.getLoad();
            if (currentLoad > remainingLoad) {
                server.decreaseLoad(remainingLoad);
                remainingLoad = remainingLoad - remainingLoad;
            } else if (currentLoad == remainingLoad) {
                server.turnOff();
                remainingLoad = remainingLoad - remainingLoad;
            } else {
                server.turnOff();
                remainingLoad = remainingLoad - currentLoad;
            }
            i++;
        }
    }

    private Stream<Server> getAllActiveServersStream() {
        return servers.stream()
                .filter(Server::isActive);
    }

    private Stream<Server> getAllInActiveServersStream() {
        return servers.stream()
                .filter(Server::isNotActive);
    }

    public void printState() {
        System.out.println();
        System.out.println("---- Data Center state ----");
        System.out.println("Servers");
        getAllActiveServersStream()
                .forEach(server -> {
                    System.out.println("    " + server.toString());
                });
        System.out.println("Total");
        System.out.println("    Total Load = " + getTotalLoad());
        System.out.println("    Total Max Load = " + getTotalMaxLoad());
        System.out.println("    Total Energy Consumption = " + getTotalEnergyConsumption());
    }

    public void printInactiveServersData() {
        getAllInActiveServersStream()
                .forEach(server -> {
                    System.out.println("    " + server.toStringForInactive());
                });
    }

    public double getTotalLoad() {
        return getAllActiveServersStream().mapToDouble(Server::getLoad).sum();
    }

    public double getTotalMaxLoad() {
        return getAllActiveServersStream().mapToDouble(Server::getMaxLoad).sum();
    }

    public double getTotalEnergyConsumption() {
        return getAllActiveServersStream().mapToDouble(Server::getEnergyConsumption).sum();
    }
}
