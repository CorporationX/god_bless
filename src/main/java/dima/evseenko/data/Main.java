package dima.evseenko.data;

import dima.evseenko.data.strategy.OptimizationStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addOptimizationStrategy(OptimizationStrategy.Strategy.LOAD_BALANCING);

        dataCenterService.addServers(getServers());
        dataCenterService.addServer(new Server(31, 120, 250));
        dataCenterService.printServers();

        System.out.println(dataCenterService.getTotalEnergyConsumption());

        System.out.println(dataCenterService.allocateResources(new ResourceRequest(20)));
        System.out.println(dataCenterService.releaseResources(new ResourceRequest(10)));
        System.out.println(dataCenterService.releaseResources(new ResourceRequest(1000)));
        dataCenterService.printServers();

        dataCenterService.optimize();
        dataCenterService.printServers();

        dataCenterService.removeOptimizationStrategy(OptimizationStrategy.Strategy.LOAD_BALANCING);
        dataCenterService.addOptimizationStrategy(OptimizationStrategy.Strategy.ENERGY_EFFICIENCY);
        dataCenterService.optimize();
        dataCenterService.printServers();
    }

    private static List<Server> getServers() {
        return List.of(
                new Server(45, 100, 200),
                new Server(200, 250, 400),
                new Server(266, 266, 300),
                new Server(90, 90, 100),
                new Server(200, 400, 400),
                new Server(120, 120, 250)
        );
    }
}
