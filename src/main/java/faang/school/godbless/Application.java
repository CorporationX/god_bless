package faang.school.godbless;

import faang.school.godbless.BJS2_433.DataCenterService;
import faang.school.godbless.BJS2_433.Server;
import faang.school.godbless.BJS2_433.optimization.PercentageServerLoadOptimizationStrategy;

public class Application {
    public static void main(String... args) {

        Server server1 = new Server(10);
        server1.setLoad(3);

        Server server2 = new Server(12);
        server2.setLoad(5);

        Server server3 = new Server(40);
        server3.setLoad(8);

        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);

        PercentageServerLoadOptimizationStrategy percentageServerLoadOptimizationStrategy = new PercentageServerLoadOptimizationStrategy(
                10, 0.5
        );

        percentageServerLoadOptimizationStrategy.optimize(dataCenterService.getDataCenter());

        System.out.println(dataCenterService.getDataCenter().getServerList());
    }
}
