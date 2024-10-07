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

        ResourceRequest firstRequest = new ResourceRequest(50);
        service.allocateResources(firstRequest);

        ResourceRequest secondRequest = new ResourceRequest(80);
        service.allocateResources(secondRequest);

        System.out.println("Total energy consumption: " + service.getTotalEnergyConsumption());

        service.releaseResources(firstRequest);
        System.out.println("Total energy consumption after release: " + service.getTotalEnergyConsumption());
    }
}

