package optimizing_the_work_of_the_data_center;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();

        Server firstServer = new Server(100, 200);
        Server secondServer = new Server(150, 250);

        dataCenter.addServer(firstServer);
        dataCenter.addServer(secondServer);

        OptimizationStrategy loadBalancingStrategy = new LoadBalancingOptimizationStrategy();
        DataCenterService service = new DataCenterService(dataCenter, loadBalancingStrategy);

        ResourceRequest request1 = new ResourceRequest(50);
        service.allocateResources(request1);

        ResourceRequest request2 = new ResourceRequest(80);
        service.allocateResources(request2);

        System.out.println("Total energy consumption: " + service.getTotalEnergyConsumption());

        service.releaseResources(request1);
        System.out.println("Total energy consumption after release: " + service.getTotalEnergyConsumption());
    }
}

