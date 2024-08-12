package faang.school.godbless;

public class Main {

    public static void main(String[] args) {

        DataCenter dataCenter = new DataCenter();
        OptimizationStrategyImpl optimizationStrategy = new OptimizationStrategyImpl();
        DataCenterService service = new DataCenterService(dataCenter, optimizationStrategy);

        Server server1 = new Server(100);
        Server server2 = new Server(200);

        service.addServer(server1);
        service.addServer(server2);

        ResourceRequest request = new ResourceRequest(50);
        service.allocateResources(request);

        System.out.println("Total Energy Consumption: " + service.getTotalEnergyConsumption());

        service.periodicOptimization();
    }
}
