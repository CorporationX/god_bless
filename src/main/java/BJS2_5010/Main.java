package BJS2_5010;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);

        dataCenterService.addServer(new Server(0, 10, 2));
        dataCenterService.addServer(new Server(0, 30, 6));
        dataCenterService.addServer(new Server(0, 25, 5));

        System.out.println(dataCenterService.getTotalEnergyConsumption());
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.allocateResources(new ResourceRequest(5));

        dataCenterService.releaseResources(new ResourceRequest(25));
        dataCenterService.releaseResources(new ResourceRequest(5));

        dataCenterService.optimize(dataCenter);

        dataCenterService.deleteServer(dataCenter.getServers().get(0));
        for (Server server: dataCenterService.getDataCenter().getServers()){
            System.out.println(server);
        }
    }
}
