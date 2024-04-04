package faang.school.godbless.bjs2_4467;

public class Main {

    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        Server server1 = new Server(0, 90, 50);
        Server server2 = new Server(0, 90, 30);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);

        System.out.println("Get energy consumption.");
        System.out.println("Total consumption: " + dataCenterService.getTotalEnergyConsumption());

        System.out.println("Remove server from Data center");
        dataCenterService.removeServer(server1);

        System.out.println("Get energy consumption.");
        System.out.println("Total consumption: " + dataCenterService.getTotalEnergyConsumption());

        System.out.println("Optimization energy efficiency");
        dataCenterService.setOptimizationStrategy(new EnergyEfficencyOptimizationStrategy());
        dataCenterService.optimizeDataCenter();

        System.out.println("Optimization Load balancing");
        dataCenterService.setOptimizationStrategy(new LoadBalancingOptimizationStrategy());
        dataCenterService.optimizeDataCenter();

        dataCenterService.allocateResources(new ResourceRequest(20));
        dataCenterService.releaseResources(new ResourceRequest(10));
    }
}
