package faang.school.godbless.bjs2_4467;

public class Main {

    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        Server server1 = new Server(0, 90, 50);
        Server server2 = new Server(0, 90, 30);
        Server server3 = new Server(0, 95, 40);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);

        dataCenterService.getTotalEnergyConsumption();

        dataCenterService.removeServer(server1);

        dataCenterService.getTotalEnergyConsumption();

        dataCenterService.setOptimizationStrategy(new EnergyEfficencyOptimizationStrategy());
        dataCenterService.optimizeDataCenter();

        dataCenterService.setOptimizationStrategy(new LoadBalancingOptimizationStrategy());
        dataCenterService.optimizeDataCenter();

        dataCenterService.allocateResources(new ResourceRequest(20));
        dataCenterService.releaseResources(new ResourceRequest(10));

        dataCenterService.removeServer(server3);
    }
}
