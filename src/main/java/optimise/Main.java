package optimise;

public class Main {
    public static void main(String[] args) {
        Server server1 = new Server(10, 100, 150);
        Server server2 = new Server(25, 250, 200);
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter, new EnergyEfficencyOptimizationStrategy());
        dataCenterService.addService(server1);
        dataCenterService.addService(server2);

        System.out.println(dataCenterService.getTotalEnergyConsumption());
        System.out.println();

        dataCenterService.removeService(server1);

        System.out.println(dataCenterService.getTotalEnergyConsumption());
        System.out.println();

        dataCenterService.optimiseDataCenter();

        dataCenterService.allocateResources(new ResourceRequest(23));
        dataCenterService.releaseResources(new ResourceRequest(2348));
    }
}
