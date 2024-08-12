package faang.school.godbless.datacenter.services;

import faang.school.godbless.datacenter.models.DataCenter;
import faang.school.godbless.datacenter.models.ResourceRequest;
import faang.school.godbless.datacenter.models.Server;

import java.util.ArrayList;

import static faang.school.godbless.datacenter.services.ServerService.*;

public class DataCenterService {

    public static void addNewServer(DataCenter dataCenter) {
        dataCenter.getServers().add(createNewServer());
    }

    public static void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    public static void deleteServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().remove(server);
    }

    public static double getTotalEnergyConsumptionInDataCenter(DataCenter dataCenter) {
        return getEnergyConsumptionOnServers(dataCenter.getServers());
    }

    public static double getTotalLoadOnAllServers(DataCenter dataCenter) {
        return getTotalLoadOnServers(dataCenter.getServers());
    }

    public static void allocateResourcesInDataCenter(ResourceRequest request, DataCenter dataCenter) {
        ArrayList<Server> dataCenterServers = getServersInDataCenter(dataCenter);
        allocateResourcesInServers(dataCenterServers, request.load());

    }

    public static void releaseResourcesInDataCenter(ResourceRequest request, DataCenter dataCenter) {
        ArrayList<Server> dataCenterServers = getServersInDataCenter(dataCenter);
        releaseResourcesInServers(dataCenterServers, request.load());
    }

    public static ArrayList<Server> getServersInDataCenter(DataCenter dataCenter) {
        return dataCenter.getServers();
    }

    public void optimize(OptimizationStrategy optimizationStrategy, DataCenter dataCenter) {
        optimizationStrategy.optimize(dataCenter);
    }
}
