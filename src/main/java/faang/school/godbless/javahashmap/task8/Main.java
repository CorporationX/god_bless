package faang.school.godbless.javahashmap.task8;

public class Main {
    public static void main(String[] args) {
        Server server1 = new Server(11.0, 20.0, 5.3);
        Server server2 = new Server(4.0, 15.0, 3.2);
        Server server3 = new Server(19.0, 20.0, 5.3);
        Server server4 = new Server(1.0, 15.0, 3.2);
        Server server5 = new Server(5.0, 20.0, 5.3);
        Server server6 = new Server(6.0, 15.0, 3.2);

        DataCenter dataCenter = new DataCenter();
        dataCenter.addServer(server1);
        dataCenter.addServer(server2);
        dataCenter.addServer(server3);
        dataCenter.addServer(server4);
        dataCenter.addServer(server5);
        dataCenter.addServer(server6);


        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        System.out.println(dataCenter);
        System.out.println();
        ResourceRequest request = new ResourceRequest(8.0);

        dataCenterService.allocateResources(request);
        System.out.println(dataCenter);
        System.out.println();
        System.out.println("Общее потребление энергии: " + dataCenterService.getTotalEnergyConsumption());
        System.out.println();

        dataCenterService.releaseResources(request);
        System.out.println(dataCenter);
        System.out.println();

        OptimizationStrategy optimizationStrategy = new LoadOptimizationStrategy();
        dataCenterService.optimize(optimizationStrategy);
        System.out.println(dataCenter);
        System.out.println();
    }
}
