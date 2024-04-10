package faang.school.godbless.data_center;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        Server server1 = new Server("Server 1", 60, 100, 80);
        Server server2 = new Server("Server 2", 80, 100, 70);
        Server server3 = new Server("Server 3", 95, 100, 90);
        dataCenterService.addServerToDataCenter(dataCenter, server1);
        dataCenterService.addServerToDataCenter(dataCenter, server2);
        dataCenterService.addServerToDataCenter(dataCenter, server3);
        dataCenterService.getTotalEnergyConsumption(dataCenter);
        ResourceRequest request = new ResourceRequest(20);
        dataCenterService.allocateResources(dataCenter, request);
        dataCenterService.releaseResources(dataCenter, request);
        dataCenterService.optimizeDataCenter();
        dataCenterService.removeServerFromDataCenter(dataCenter, server1);
    }
}
