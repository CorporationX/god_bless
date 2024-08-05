package faang.school.godbless.datacenter.services;

import faang.school.godbless.datacenter.models.DataCenter;
import faang.school.godbless.datacenter.models.ResourceRequest;
import faang.school.godbless.datacenter.models.Server;

import java.util.ArrayList;

public class DataCenterService implements OptimizationStrategy {

    public static void addNewServer(DataCenter dataCenter) {

        Server server = new Server(0);

        dataCenter.getServers().add(server);
    }

    public static void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    public static void deleteServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().remove(server);
    }

    public static double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getServers().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public static double getTotalLoadOnAllServers(DataCenter dataCenter) {
        return dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
    }

    public static void allocateResources(ResourceRequest request, DataCenter dataCenter) {

        ArrayList<Server> dataCenterServers = getServersInDataCenter(dataCenter);

        dataCenterServers.stream()
                .filter(server -> (server.getMaxLoad() - server.getLoad() >= request.getLoad()))
                .findFirst()
                .ifPresentOrElse((server -> {
                            server.setLoad(server.getLoad() + request.getLoad());
                            server.setEnergyConsumption(server.getEnergyConsumption() + request.getLoad());
                        }),
                        () -> {
                            double needToCreate = request.getLoad();

                            for (Server server : dataCenterServers) {
                                if (server.getLoad() < 100) {
                                    double emptyLoadOnServer = 100 - server.getLoad();
                                    server.setLoad(server.getLoad() + emptyLoadOnServer);
                                    needToCreate -= emptyLoadOnServer;
                                }
                            }

                            while (needToCreate > 0) {

                                if (needToCreate > 100) {
                                    addServer(dataCenter, new Server(100));
                                    needToCreate -= 100;
                                } else {
                                    addServer(dataCenter, new Server(needToCreate));
                                    needToCreate -= needToCreate;
                                }
                            }
                        });
    }

    public static void releaseResources(ResourceRequest request, DataCenter dataCenter) {

        ArrayList<Server> dataCenterServers = getServersInDataCenter(dataCenter);

        dataCenterServers.stream()
                .filter(server -> (server.getLoad() - request.getLoad() >= 0))
                .findFirst()
                .ifPresentOrElse((server -> {
                            server.setLoad(server.getLoad() - request.getLoad());
                            server.setEnergyConsumption(server.getEnergyConsumption() - request.getLoad());
                        }),
                        () -> {
                            if (!dataCenterServers.isEmpty()) {

                                double needToRelease = request.getLoad();

                                for (Server server : dataCenterServers) {
                                    double serverLoad = server.getLoad();
                                    if (needToRelease >= serverLoad) {
                                        server.setLoad(server.getLoad() - serverLoad);
                                        server.setEnergyConsumption(server.getEnergyConsumption() - serverLoad);
                                        needToRelease -= serverLoad;
                                    } else {
                                        server.setLoad(server.getLoad() - needToRelease);
                                        server.setEnergyConsumption(server.getEnergyConsumption() - needToRelease);
                                        needToRelease -= needToRelease;
                                    }
                                    if (needToRelease <= 0) {
                                        return;
                                    }
                                }
                            }
                        });
    }

    public static ArrayList<Server> getServersInDataCenter(DataCenter dataCenter) {
        return dataCenter.getServers();
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        double commonLoad = getTotalLoadOnAllServers(dataCenter);
        double optimizeLoad = commonLoad / dataCenter.getServers().size();

        for (Server server : dataCenter.getServers()) {
            double serverLoad = server.getLoad();
            if (serverLoad > optimizeLoad) {
                double differenceIdLoad = serverLoad - optimizeLoad;
                server.setLoad(optimizeLoad);
                server.setEnergyConsumption(server.getEnergyConsumption() - differenceIdLoad);
            } else if (serverLoad < optimizeLoad) {
                double differenceIdLoad = optimizeLoad - serverLoad;
                server.setLoad(optimizeLoad);
                server.setEnergyConsumption(server.getEnergyConsumption() + differenceIdLoad);
            }
        }
    }
}
