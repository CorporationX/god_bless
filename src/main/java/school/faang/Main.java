package school.faang;

public class Main {
    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService();
        DataCenter dataCenter = new DataCenter();
        dataCenterService.addServer(dataCenter, new Server(10, 90, 10));
        dataCenterService.addServer(dataCenter, new Server(90, 100, 50));
        dataCenterService.optimize(new EnergyEfficiencyOptimizationStrategy(), dataCenter);

        dataCenterService.removeServer(dataCenter, new Server(10, 20, 5));

        System.out.println(dataCenterService.getTotalEnergyConsumption(dataCenter));
        dataCenterService.allocateResources(dataCenter, new ResourceRequest(30));
        dataCenterService.releaseResources(dataCenter, new ResourceRequest(10));
        dataCenterService.optimize(new LoadBalancingOptimizationStrategy(), dataCenter);
    }
}
