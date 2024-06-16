package faang.school.godbless.BJS28666;

import java.util.concurrent.ScheduledExecutorService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataCenter dataCenter = new DataCenter();
        DataCenterService service = new DataCenterService(dataCenter);

        service.printServers();

        Server server1 = new Server(10, 100, 10);
        Server server2 = new Server(10, 100, 20);
        Server server3 = new Server(10, 100, 30);
        Server server4 = new Server(10, 100, 40);
        Server server5 = new Server(10, 300, 10);
        service.addServer(server1);
        service.addServer(server1);
        service.addServer(server3);
        service.addServer(server4);
        service.addServer(server2);

        service.printServers();

        service.removeServer(server1);
        service.removeServer(server1);
        service.printServers();

        System.out.println("DataCenter total energy consumption: " + dataCenter.getTotalEnergyConsumption());
        System.out.println("DataCenter total free resources: " + dataCenter.getTotalFreeResources());
        System.out.println("DataCenter total load: " + dataCenter.getTotalLoad());

        service.allocateResources(new ResourceRequest(200));
        service.allocateResources(new ResourceRequest(100));
        service.allocateResources(new ResourceRequest(50));
        service.allocateResources(new ResourceRequest(60));

        service.printServers();

        service.releaseResources(new ResourceRequest(40));
        service.printServers();

        service.addServer(server1);
        service.printServers();
        ScheduledExecutorService scheduler =
                service.runOptimizationStrategy(new EnergyEfficencyOptimizationStrategy(), 5);
        Thread.sleep(1000);

        service.printServers();
        service.addServer(server5);
        service.printServers();

        Thread.sleep(5000);
        service.printServers();


        scheduler.shutdown();

        System.out.println("\nChecking AverageLoadOptimizationStrategy\n");

        scheduler = service.runOptimizationStrategy(new AverageLoadOptimizationStrategy(), 5);
        Thread.sleep(1000);

        service.printServers();
        service.addServer(new Server(30, 200, 100));
        service.printServers();

        Thread.sleep(5000);
        service.printServers();


        scheduler.shutdown();
    }
}
