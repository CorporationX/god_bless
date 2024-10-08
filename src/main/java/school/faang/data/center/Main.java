package school.faang.data.center;

import school.faang.data.center.strategy.impl.EnergyEfficencyOptimizationStrategy;
import school.faang.data.center.strategy.impl.LoadBalancingOptimizationStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Server server1 = new Server(400, 600, 25);
        Server server2 = new Server(200, 400, 50);
        Server server3 = new Server(100, 500, 20);
        Server server4 = new Server(300, 400, 10);
        Server server5 = new Server(500, 600, 34);
        List<Server> servers = new ArrayList<>(List.of(server1, server2, server3, server4, server5));

        testDataCenterService(servers, new LoadBalancingOptimizationStrategy());
        testDataCenterService(servers, new EnergyEfficencyOptimizationStrategy());
    }

    public static void testDataCenterService(List<Server> servers,
                                             OptimizationStrategy optimizationStrategy) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(optimizationStrategy);
        for (Server server : servers) {
            dataCenterService.add(server, dataCenter);
        }

        System.out.println("Сервера после добавления");
        dataCenterService.printReport(dataCenter);
        System.out.println();

        System.out.println("Сервера после удаления");
        dataCenterService.remove(servers.get(4), dataCenter);
        dataCenterService.printReport(dataCenter);
        System.out.println();

        System.out.println("Сервера выделения ресурсов");
        dataCenterService.allocateResources(new ResourceRequest(100), dataCenter);
        dataCenterService.printReport(dataCenter);
        System.out.println();

        System.out.println("Сервера освобождения ресурсов");
        dataCenterService.releaseResources(new ResourceRequest(500), dataCenter);
        dataCenterService.printReport(dataCenter);
        System.out.println();
    }
}
