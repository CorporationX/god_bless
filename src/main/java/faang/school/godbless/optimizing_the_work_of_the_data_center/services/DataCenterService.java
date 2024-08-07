package faang.school.godbless.optimizing_the_work_of_the_data_center.services;

import faang.school.godbless.optimizing_the_work_of_the_data_center.interfaces.OptimizationStrategy;
import faang.school.godbless.optimizing_the_work_of_the_data_center.main.DataCenter;
import faang.school.godbless.optimizing_the_work_of_the_data_center.main.ResourceRequest;
import faang.school.godbless.optimizing_the_work_of_the_data_center.main.Server;

import java.util.List;

public class DataCenterService {
    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        if (dataCenter.getServers().contains(server)) {
            List<Server> servers = dataCenter.getServers();
            servers.remove(server);
            dataCenter.setServers(servers);
        }
    }

    public void getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        System.out.println("Total energy consumption: " + totalEnergyConsumption);
    }

    public void allocateResources(DataCenter dataCenter, ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() + request.getLoad() <= server.getMaxLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
                break;
            }

        }
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() - request.getLoad() >= 0) {
                server.setLoad(server.getLoad() - request.getLoad());
                break;
            }
        }
    }

    public void optimize(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        optimizationStrategy.optimize(dataCenter);
    }
}
