package ru.kraiush.BJS2_33156;

public class Main {

    public static void main(String[] args) {
        Server server1 = new Server(20.9);
        Server server2 = new Server(50.4);
        Server server3 = new Server(10.8);
        Server server4 = new Server(54.6);
        Server server5 = new Server(35.5);
        Server server6 = new Server(20.2);

        DataCenterService dataCenterService = new DataCenterService(new DataCenter());

        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);
        dataCenterService.addServer(server4);
        dataCenterService.addServer(server5);
        dataCenterService.addServer(server6);
        dataCenterService.getDataCenterInfo();

        dataCenterService.deleteServer(server1);
        dataCenterService.getDataCenterInfo();

        dataCenterService.allocateResources(new ResourceRequest(100.8));
        dataCenterService.allocateResources(new ResourceRequest(20.4));
        dataCenterService.allocateResources(new ResourceRequest(14.6));
        dataCenterService.getDataCenterInfo();

        dataCenterService.releaseResources(new ResourceRequest(60));
        dataCenterService.getDataCenterInfo();

        dataCenterService.optimizeDataCenter();
        dataCenterService.getDataCenterInfo();

        System.out.println("Current total consumption: " + dataCenterService.getTotalEnergyConsumption());
    }
}
