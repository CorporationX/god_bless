package school.faang.bjs2_79724;

public class DemoApp {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();

        DataCenterService service = new DataCenterService(new LoadBalancingOptimizationStrategy());

        Server server1 = new Server(0, 100, 0);
        Server server2 = new Server(0, 150, 0);
        Server server3 = new Server(0, 200, 0);

        service.addServer(dataCenter, server1);
        service.addServer(dataCenter, server2);
        service.addServer(dataCenter, server3);

        ResourceRequest request = new ResourceRequest(250);

        boolean success = service.allocateResources(dataCenter, request);
        System.out.println("Resources allocated: " + success);

        System.out.println("Total load: " + service.getTotalLoad(dataCenter));
        System.out.println("Total energy consumption: " + service.getTotalEnergyConsumption(dataCenter));

        service.optimize(dataCenter);

        System.out.println("\nAfter LoadBalancing Optimization:");
        printServerStates(dataCenter, service);

        DataCenterService energyService = new DataCenterService(new EnergyEfficiencyOptimizationStrategy());
        energyService.optimize(dataCenter);

        System.out.println("\nAfter EnergyEfficiency Optimization:");
        printServerStates(dataCenter, energyService);

        service.removeServer(dataCenter, server3);
        System.out.println("\nAfter removing Server 3:");
        printServerStates(dataCenter, service);

        service.releaseResources(dataCenter, request);
        System.out.println("\nAfter releasing resources:");
        printServerStates(dataCenter, service);
    }

    private static void printServerStates(DataCenter dataCenter, DataCenterService service) {
        int i = 1;
        for (Server server : dataCenter.getServers()) {
            System.out.printf("Server %d -> Load: %.2f, Energy: %.2f%n", i++, server.getLoad(), server
                    .getEnergyConsumption());
        }
        System.out.printf("Total Load: %.2f%n", service.getTotalLoad(dataCenter));
        System.out.printf("Total Energy Consumption: %.2f%n", service.getTotalEnergyConsumption(dataCenter));
    }
}