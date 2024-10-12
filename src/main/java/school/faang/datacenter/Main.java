package school.faang.datacenter;

public class Main {
    public static void main(String[] args) {
        Server gameServer = new Server(100.0, 300.0, 500.0);
        Server workServerFirst = new Server(200.0, 500.0, 900.0);
        Server workServerSecond = new Server(300.0, 500.0, 1000.0);

        DataCenter dataCenter = new DataCenter();
        LoadBalancingOptimizationStrategy optimizationStrategy = new LoadBalancingOptimizationStrategy();
        DataCenterService service = new DataCenterService(dataCenter, optimizationStrategy);

        service.addServer(gameServer);
        service.addServer(workServerFirst);
        service.addServer(workServerSecond);
        service.printAllServer();
        System.out.println("-----------------");
        service.removeServer(workServerSecond);
        service.printAllServer();
        System.out.println("-----------------");
        service.optimize(dataCenter);
        service.printAllServer();
        System.out.println("-----------------");
        System.out.println("Total Energy Consumption " + service.getTotalEnergyConsumption());
        System.out.println("-----------------");
        service.allocateResources(new ResourceRequest(50.0));
        service.printAllServer();
        System.out.println("-----------------");
        service.releaseResources(new ResourceRequest(100.0));
        service.printAllServer();
    }
}
