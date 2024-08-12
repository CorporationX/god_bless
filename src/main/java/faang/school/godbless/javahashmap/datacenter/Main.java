package faang.school.godbless.javahashmap.datacenter;

public class Main {

    public static void main(String[] args) {

        DataCenter dataCenter = new DataCenter();

        OptimizationStrategy optimizationStrategy = new LoadBalancingOptimizationStrategy();

        DataCenterService dataCenterService = new DataCenterService(dataCenter, optimizationStrategy);

        dataCenterService.addServer(new Server());
        dataCenterService.addServer(new Server());
        dataCenterService.addServer(new Server());

        dataCenterService.printServers();

        dataCenterService.allocateResources(new ResourceRequest(50));
        dataCenterService.allocateResources(new ResourceRequest(50));

        dataCenterService.printServers();

        dataCenterService.optimizeLoad();

        dataCenterService.printServers();
    }
}
