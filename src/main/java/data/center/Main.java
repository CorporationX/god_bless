package data.center;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server1 = new Server(100, 600);
        Server server2 = new Server(150, 80);
        Server server3 = new Server(120, 700);
        Server server4 = new Server(100, 500);
        Server server5 = new Server(130, 900);

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
        ResourceRequest request6 = new ResourceRequest(50);
        ResourceRequest request7 = new ResourceRequest(80);

        try {
            dataCenterService.allocateResources(request1);
            dataCenterService.allocateResources(request2);
            dataCenterService.allocateResources(request3);
            dataCenterService.allocateResources(request4);
            dataCenterService.allocateResources(request6);
            dataCenterService.allocateResources(request7);
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
