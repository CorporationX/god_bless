package faang.school.godbless.optimizing_the_work_of_the_data_center;

import faang.school.godbless.optimizing_the_work_of_the_data_center.main.DataCenter;
import faang.school.godbless.optimizing_the_work_of_the_data_center.main.ResourceRequest;
import faang.school.godbless.optimizing_the_work_of_the_data_center.main.Server;
import faang.school.godbless.optimizing_the_work_of_the_data_center.services.DataCenterService;
import faang.school.godbless.optimizing_the_work_of_the_data_center.strategy.EnergyEfficencyOptimizationStrategy;
import faang.school.godbless.optimizing_the_work_of_the_data_center.strategy.LoadBalancingOptimizationStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService();
        List<Server> servers = new ArrayList<>(){
            {
                add(new Server(0.5, 10, 0.5));
                add(new Server(10, 100, 30));
            }
        };

        DataCenter dataCenter = new DataCenter(servers);

        dataCenterService.addServer(dataCenter, new Server(0, 10, 1));
        dataCenterService.getTotalEnergyConsumption(dataCenter);
        dataCenterService.removeServer(dataCenter, new Server(0, 10, 1));
        dataCenterService.getTotalEnergyConsumption(dataCenter);

        servers.forEach(server -> System.out.println(server.getLoad()));

        ResourceRequest request = new ResourceRequest(3);
        dataCenterService.allocateResources(dataCenter, request);
        servers.forEach(server -> System.out.println(server.getLoad()));

        request = new ResourceRequest(10);
        dataCenterService.allocateResources(dataCenter, request);
        servers.forEach(server -> System.out.println(server.getLoad()));

        request = new ResourceRequest(3);
        dataCenterService.releaseResources(dataCenter, request);
        servers.forEach(server -> System.out.println(server.getLoad()));

        dataCenterService.optimize(dataCenter, new EnergyEfficencyOptimizationStrategy());
        servers.forEach(server -> System.out.println(server.getLoad()));

        dataCenterService.optimize(dataCenter, new LoadBalancingOptimizationStrategy());
        servers.forEach(server -> System.out.println(server.getLoad()));
    }
}
