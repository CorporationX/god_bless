package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService();

        Server server1 = new Server(100, 50);
        Server server2 = new Server(200, 70);
        Server server3 = new Server(150, 60);

        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);

        ResourceRequest request = new ResourceRequest(50);
        dataCenterService.allocateResources(request);

        System.out.println("Total Energy Consumption: " + dataCenterService.getTotalEnergyConsumption());

    }
}