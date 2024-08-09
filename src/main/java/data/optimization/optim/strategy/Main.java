package data.optimization.optim.strategy;

import data.optimization.DataCenter;
import data.optimization.DataCenterService;
import data.optimization.ResourceRequest;
import data.optimization.Server;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        OptimizationStrategy strategy = new SillyOptimizationStrategy();
        DataCenterService.setOptimizationStrategy(strategy);
        Server server1 = new Server(8, 1);
        Server server2 = new Server(4, 1);
        Server server3 = new Server(6, 1);
        DataCenterService.addServer(dataCenter, server1);
        DataCenterService.addServer(dataCenter, server2);
        DataCenterService.addServer(dataCenter, server3);
        ResourceRequest request1 = new ResourceRequest(4);
        ResourceRequest request2 = new ResourceRequest(4);
        ResourceRequest request3 = new ResourceRequest(4);
        dataCenter.getInfo();
        DataCenterService.allocateResource(dataCenter, request1);
        DataCenterService.allocateResource(dataCenter, request2);
        DataCenterService.allocateResource(dataCenter, request3);
        dataCenter.getInfo();
        System.out.println(DataCenterService.getTotalEnergyConsumption(dataCenter));
        DataCenterService.optimize(dataCenter);
        dataCenter.getInfo();
        System.out.println(DataCenterService.getTotalEnergyConsumption(dataCenter));
        DataCenterService.releaseResource(dataCenter, request1);
        dataCenter.getInfo();
    }
}
