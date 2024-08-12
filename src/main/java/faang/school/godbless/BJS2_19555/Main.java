package faang.school.godbless.BJS2_19555;

import faang.school.godbless.BJS2_19555.strategy.LoadBalancingOptimizationStrategy;
import lombok.AllArgsConstructor;

import java.util.Timer;

@AllArgsConstructor
public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(new Timer());
        Server server1 = new Server(12, 20, 5);
        Server server2 = new Server(24, 26, 8);
        dataCenterService.addServer(dataCenter, server1);
        dataCenterService.addServer(dataCenter, server2);
//        dataCenterService.removeServer(dataCenter, server2);
        System.out.println("Total energy consumption is " + dataCenterService.getTotalEnergyConsumption(dataCenter));
//        dataCenterService.allocateResources(dataCenter, new ResourceRequest(7));
//        dataCenterService.releaseResources(dataCenter, new ResourceRequest(8));
        dataCenterService.optimize(dataCenter, new LoadBalancingOptimizationStrategy());
    }
}

