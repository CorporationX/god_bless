package faang.school.godbless.BJS2_433;

import faang.school.godbless.BJS2_433.optimization.PercentageServerLoadOptimizationStrategy;

public class Main {
    public static void main(String[] args) {
        Server server1 = new Server(10);
        server1.setLoad(8);

        Server server2 = new Server(7);
        server2.setLoad(5);

        Server server3 = new Server(10);
        server3.setLoad(8);

        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);

        PercentageServerLoadOptimizationStrategy optimizationStrategy = new PercentageServerLoadOptimizationStrategy(10, 0.6);

        optimizationStrategy.optimize(dataCenterService.getDataCenter());

        System.out.println(dataCenterService.getDataCenter().getServerList());

        dataCenterService.allocateResources(new ResourceRequest(10));

        System.out.println(dataCenterService.getDataCenter().getServerList());
    }
}