package faang.school.godbless.javahashmap.task2dataserver;

public class Application {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();

        Server server1 = new Server(100,111,5);
        Server server2 = new Server(150,160,7);
        Server server3 = new Server(150,200,6);

        DataCenterService.addServer(server1);
        DataCenterService.addServer(server2);
        DataCenterService.addServer(server3);

        ResourceRequest request = new ResourceRequest(1300);

        DataCenterService.allocateResources(request);
        DataCenterService.releaseResources(request);


        System.out.println("Общее энергопотребление: " + DataCenterService.getTotalEnergyConsumption());

    }
}
