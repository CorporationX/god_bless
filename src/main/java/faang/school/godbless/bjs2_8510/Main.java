package faang.school.godbless.bjs2_8510;

import faang.school.godbless.bjs2_8510.strategy.EnergyEfficencyOptimizationStrategy;
import faang.school.godbless.bjs2_8510.strategy.LoadBalancingOptimizationStrategy;
import faang.school.godbless.bjs2_8510.strategy.OptimizationIncreaseMiddleLoadStrategy;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Server> servers = new ArrayList<>();
    servers.add(new Server(90.0, 100.0));
    servers.add(new Server(30.0, 100.0));
    servers.add(new Server(90.0, 150.0));
    DataCenter dataCenter = new DataCenter(servers);
    DataCenterService dataCenterService = new DataCenterService(dataCenter,
        new OptimizationIncreaseMiddleLoadStrategy());

    dataCenterService.addServer(new Server(135.0, 150.0));
    dataCenterService.addServer(new Server(15.0, 100.0));

    System.out.println("0 " + servers);

    dataCenterService.allocateResources(new ResourceRequest(100.0));
    dataCenterService.releaseResources(new ResourceRequest(100.0));
    System.out.println("1 " + servers);

    dataCenterService.optimize(dataCenter);
    System.out.println("2 " + servers);

    dataCenterService.setOptimizationStrategy(new LoadBalancingOptimizationStrategy());
    dataCenterService.optimize(dataCenter);
    System.out.println("3 " + servers);

    dataCenterService.setOptimizationStrategy(new EnergyEfficencyOptimizationStrategy());
    dataCenterService.optimize(dataCenter);
    System.out.println("4 " + servers);
  }

}
