package data.center;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server1 = new Server(100, 600, 1, 1);
        Server server2 = new Server(150, 800, 1.2, 2);
        Server server3 = new Server(120, 700, 0.5, 1.3);
        Server server4 = new Server(100, 500, 0.8, 1);
        Server server5 = new Server(130, 900, 0.1, 0.5);

        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(new LoadBalancingOptimizationStrategy(), dataCenter);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);
        dataCenterService.addServer(server4);
        dataCenterService.addServer(server5);

        ResourceRequest request1 = new ResourceRequest(55);
        ResourceRequest request2 = new ResourceRequest(30);
        ResourceRequest request3 = new ResourceRequest(10);
        ResourceRequest request4 = new ResourceRequest(20);
        ResourceRequest request5 = new ResourceRequest(30);
        ResourceRequest request6 = new ResourceRequest(50);
        ResourceRequest request7 = new ResourceRequest(80);
        ResourceRequest request8 = new ResourceRequest(20);
        ResourceRequest request9 = new ResourceRequest(10);

        try {
            dataCenterService.allocateResources(request1);
            dataCenterService.allocateResources(request2);
            dataCenterService.allocateResources(request3);
            dataCenterService.allocateResources(request4);
            dataCenterService.allocateResources(request5);
            dataCenterService.allocateResources(request6);
            dataCenterService.allocateResources(request7);
            dataCenterService.allocateResources(request8);
            dataCenterService.allocateResources(request9);
        } catch (Exception exception) {
            System.out.printf("\nОшибка при запросе ресурсов: %s", exception.getMessage());
        }

        System.out.println("Прямое размещение без оптимизации");
        dataCenterService.getInfo();
        System.out.println("Применение оптимизации LoadBalancingOptimizationStrategy");
        dataCenterService.optimize();
        dataCenterService.getInfo();

        dataCenterService.setStrategy(new EnergyEfficencyOptimizationStrategy());
        System.out.println("Применение оптимизации EnergyEfficencyOptimizationStrategy");
        dataCenterService.optimize();
        dataCenterService.getInfo();
    }
}
