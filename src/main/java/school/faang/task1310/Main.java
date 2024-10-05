package school.faang.task1310;

public class Main {
    public static void main(String[] args) {
        Server firstServer = new Server(25, 100, 300);
        Server secondServer = new Server(75, 100, 225);
        Server thirdServer = new Server(50, 100, 250);
        Server serverForRemove = new Server(4350, 10330, 2530);

        DataCenter dataCenter = new DataCenter();
        LoadBalancingOptimizationStrategy optimizationStrategy = new LoadBalancingOptimizationStrategy();
        DataCenterService dataCenterService = new DataCenterService(dataCenter, optimizationStrategy);

        dataCenterService.addServer(firstServer);
        dataCenterService.addServer(secondServer);
        dataCenterService.addServer(thirdServer);
        dataCenterService.addServer(serverForRemove);
        dataCenterService.printAllServer();
        System.out.println();

        dataCenterService.removeServer(serverForRemove);
        dataCenterService.printAllServer();
        System.out.println();

        dataCenterService.optimize();
        dataCenterService.printAllServer();
        System.out.println();

        System.out.println(dataCenterService.getTotalEnergyConsumption());
        System.out.println();

        ResourceRequest resourceRequest = new ResourceRequest(33);
        dataCenterService.allocateResources(resourceRequest);
        dataCenterService.printAllServer();
        System.out.println();

        ResourceRequest secondresourceRequest = new ResourceRequest(43);
        dataCenterService.releaseResources(secondresourceRequest);
        dataCenterService.printAllServer();
        System.out.println();
    }
}
