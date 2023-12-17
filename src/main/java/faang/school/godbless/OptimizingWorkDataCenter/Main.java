package faang.school.godbless.OptimizingWorkDataCenter;

public class Main {
    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(new Server(20, 100, 220));
        dataCenterService.addServer(new Server(30, 100, 230));
        dataCenterService.addServer(new Server(40, 100, 240));
        dataCenterService.addServer(new Server(50, 100, 250));
        dataCenterService.addServer(new Server(60, 100, 260));
        dataCenterService.addServer(new Server(70, 100, 270));
        printInfo(dataCenterService);

        dataCenterService.deleteServer(new Server(40, 100, 240));
        printInfo(dataCenterService);

        System.out.println(dataCenterService.getTotalEnergyConsumption() + " потребляется энергии");

        ResourceRequest request1 = new ResourceRequest(25);
        ResourceRequest request2 = new ResourceRequest(95);

        dataCenterService.allocateResources(request1);
        dataCenterService.allocateResources(request2);
        printInfo(dataCenterService);

        dataCenterService.releaseResources(request1);
        dataCenterService.releaseResources(request2);
        printInfo(dataCenterService);

    }

    public static void printInfo(DataCenterService servers) {
        System.out.println("Список серверов");
        for (Server server : servers.getDataCenter().getServerSet())
            System.out.println(server);
    }
}
