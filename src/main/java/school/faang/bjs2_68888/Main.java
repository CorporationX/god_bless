package school.faang.bjs2_68888;

public class Main {
    private static final double SMALL_LOAD = 100;
    private static final double MEDIUM_LOAD = 500;
    private static final double HIGH_LOAD = 10_000;

    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        dataCenter.addServer(dataCenter, new Server(100, 1000, 3));
        dataCenter.addServer(dataCenter, new Server(200, 800, 1));
        dataCenter.addServer(dataCenter, new Server(1900, 2000, 9));
        dataCenter.addServer(dataCenter, new Server(10, 10, 1));
        DataCenterService.allocateResources(dataCenter, new ResourceRequest(SMALL_LOAD));
        DataCenterService.allocateResources(dataCenter, new ResourceRequest(MEDIUM_LOAD));
        DataCenterService.allocateResources(dataCenter, new ResourceRequest(HIGH_LOAD));
        System.out.println(dataCenter.getServers());
        dataCenter.removeServer(dataCenter, new Server(10, 10, 1));
        System.out.println(dataCenter.getServers());
        DataCenterService.optimizeLoad(new LoadBalancingOptimizationStrategy(), dataCenter);
        System.out.println(dataCenter.getServers());
        dataCenter.addServer(dataCenter, new Server(0, 10, 9));
        DataCenterService.optimizeLoad(new EnergyEfficiencyOptimizationStrategy(), dataCenter);
        DataCenterService.releaseResources(dataCenter, new ResourceRequest(HIGH_LOAD));
        System.out.println(dataCenter.getServers());
    }
}
