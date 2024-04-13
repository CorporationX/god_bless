package faang.school.godbless.database_center;

public class Main {
    public static void main(String[] args) {

        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        OptimizationService optService = new OptimizationService();

        Server server1 = new Server(10, 40, 33);
        Server server2 = new Server(20, 60, 44);
        Server server3 = new Server(30, 70, 55);
        Server server4 = new Server(0, 50, 22);

        dataCenterService.addDataCenter(server1);
        dataCenterService.addDataCenter(server2);
        dataCenterService.addDataCenter(server3);
        dataCenterService.addDataCenter(server4);

        dataCenterService.removeServer(server4);

        double totalEnergyConsumption = dataCenterService.getTotalEnergyConsumption();
        System.out.println("Total Energy consumption: " + totalEnergyConsumption);

        ResourceRequest request1 = new ResourceRequest(10);
        dataCenterService.allocateResources(request1);

        ResourceRequest request2 = new ResourceRequest(15);
        dataCenterService.releaseResources(request2);

        System.out.println("before optimize: ");
        System.out.println(dataCenterService.getInfoServers());

        optService.optimize(dataCenter);
        System.out.println("after optimize: ");

        System.out.println(dataCenterService.getInfoServers());
    }
}