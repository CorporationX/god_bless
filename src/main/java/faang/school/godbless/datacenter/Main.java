package faang.school.godbless.datacenter;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService service = new DataCenterService(dataCenter);

        Server server1 = new Server(100.0, 200.0);
        Server server2 = new Server(100.0, 150.0);
        Server server3 = new Server(100.0, 250.0);

        service.addServer(server1);
        service.addServer(server2);
        service.addServer(server3);

        ResourceRequest request = new ResourceRequest(50.0);
        service.allocateResources(request);

        service.setOptimizationStrategy(new LoadBalancingOptimizationStrategy());
        service.optimizeLoad();

        System.out.println("Total Energy Consumption: " + service.getTotalEnergyConsumption());
    }
}
