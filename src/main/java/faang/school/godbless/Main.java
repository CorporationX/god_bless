package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService(
                new DataCenter(),
                new LoadBalancingOptimizationStrategy()
        );

        dataCenterService.addServer(new Server(100, 200));
        dataCenterService.addServer(new Server(100, 150));
        dataCenterService.addServer(new Server(100, 180));

        Server server = new Server(100, 120);

        dataCenterService.addServer(server);
        dataCenterService.removeServer(server);

        allocateLoad(dataCenterService, 50);
        allocateLoad(dataCenterService, 30);
        allocateLoad(dataCenterService, 80);
        allocateLoad(dataCenterService, 1000);

        releaseLoad(dataCenterService, 20);
        releaseLoad(dataCenterService, 1000);

        System.out.println("Current load distribution");
        dataCenterService.getServers().forEach(s -> System.out.println(s.getLoad()));

        dataCenterService.optimize();

        System.out.println("Current load distribution");
        dataCenterService.getServers().forEach(s -> System.out.println(s.getLoad()));

        System.out.println("Total energy consumption: " + dataCenterService.getTotalEnergyConsumption());
    }

    private static void allocateLoad(DataCenterService dataCenterService, double load) {
        ResourceRequest request = new ResourceRequest(load);
        if (dataCenterService.allocateResources(request)) {
            System.out.println("Data Center has been allocated the load " + load);
        } else {
            System.out.println("Data Center couldn't allocate the load " + load);
        }
    }

    private static void releaseLoad(DataCenterService dataCenterService, double load) {
        ResourceRequest request = new ResourceRequest(load);
        if (dataCenterService.releaseResources(request)) {
            System.out.println("Data Center has been released the load " + load);
        } else {
            System.out.println("Data Center couldn't release the load " + load);
        }
    }
}