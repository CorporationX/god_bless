package faang.school.godbless.database_center;

public class Main {
    public static void main(String[] args) {

        Server server1 = new Server(70, 50, 40);
        Server server2 = new Server(33, 60, 60);
        Server server3 = new Server(24, 70, 80);

        DataCenterService dataCenterService = new DataCenterService();

        dataCenterService.addDataCenter(server1);
        dataCenterService.addDataCenter(server2);
        dataCenterService.addDataCenter(server3);

        double result1 = dataCenterService.getTotalEnergyConsumption();
        System.out.println("Result1 total energy consumption: " + result1);

        dataCenterService.removeServer(server2);

        double result2 = dataCenterService.getTotalEnergyConsumption();
        System.out.println("Result2 total energy consumption: " + result2);

        System.out.println(dataCenterService.getServers());

        ResourceRequest request1 = new ResourceRequest(20);
        dataCenterService.allocateResources(request1);

        ResourceRequest request2 = new ResourceRequest(12);
        dataCenterService.releaseResources(request2);

        System.out.println("server1" + server1);
        System.out.println("server2" + server2);
        System.out.println("server3" + server3);

        System.out.println("before optimize: ");
        dataCenterService.optimize();
        System.out.println("after optimize: ");

        System.out.println("server1" + server1);
        System.out.println("server2" + server2);
        System.out.println("server3" + server3);
    }
}
