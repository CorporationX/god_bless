package BJS2_5010;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        OptimizationStrategy optimizationStrategy = new LoadBalancingOptimizationStrategy();

        dataCenter.addServer(new Server(0, 10, 2));
        dataCenter.addServer(new Server(0, 30, 6));
        dataCenter.addServer(new Server(0, 25, 5));

        System.out.println(dataCenter.getTotalEnergyConsumption());
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(5));

        dataCenterService.releaseResources(new ResourceRequest(25));
        dataCenterService.releaseResources(new ResourceRequest(5));

        dataCenterService.optimize(optimizationStrategy);

        dataCenter.deleteServer(dataCenter.getServers().get(0));
        for (Server server : dataCenter.getServers()) {
            System.out.println(server);
        }
    }
}
