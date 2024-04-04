package faang.school.godbless.javaHashMap.dataCenter;

import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService();


        dataCenterService.printAllServersInfo();

        System.out.println("------------------------------------------");

        dataCenterService.removeServer(12, 120, 30);

        dataCenterService.printAllServersInfo();

        System.out.println("------------------------------------------");

        dataCenterService.addServer( 200, 50);

        dataCenterService.printAllServersInfo();

        System.out.println("------------------------------------------");

        dataCenterService.allocateResources(new ResourceRequest(50.0));

        System.out.println("------------------------------------------");

        dataCenterService.printAllServersInfo();

        System.out.println("------------------------------------------");

        dataCenterService.allocateResources(new ResourceRequest(100.0));
        dataCenterService.allocateResources(new ResourceRequest(70.0));
        dataCenterService.allocateResources(new ResourceRequest(50.0));
        dataCenterService.allocateResources(new ResourceRequest(70.0));
        dataCenterService.allocateResources(new ResourceRequest(50.0));
        dataCenterService.allocateResources(new ResourceRequest(70.0));
        dataCenterService.allocateResources(new ResourceRequest(50.0));

        System.out.println("------------------------------------------");

        dataCenterService.printAllServersInfo();

        System.out.println("------------------------------------------");

        dataCenterService.optimizeDataCenter();

        System.out.println("------------------------------------------");

        dataCenterService.printAllServersInfo();

        System.out.println("------------------------------------------");

    }
}
