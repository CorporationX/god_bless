package faang.school.godbless.beksultan2005;

public class Main {
    private static DataCenter dataCenter = new DataCenter();
    private static final DataCenterService dataCenterService = new DataCenterService(dataCenter);

    public static void main(String[] args) {

        Server server1 = new Server(0.40);
        Server server2 = new Server(0.40);
        Server server3 = new Server(0.30);
        Server server4 = new Server(0.40);
        Server server5 = new Server(0.30);

        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);
        dataCenterService.addServer(server4);
        dataCenterService.addServer(server5);

        ResourceRequest resourceRequest1 = new ResourceRequest(0.12);
        ResourceRequest resourceRequest2 = new ResourceRequest(0.08);
        ResourceRequest resourceRequest3 = new ResourceRequest(0.04);
        ResourceRequest resourceRequest4 = new ResourceRequest(0.22);
        ResourceRequest resourceRequest5 = new ResourceRequest(0.12);
        ResourceRequest resourceRequest6 = new ResourceRequest(0.04);
        ResourceRequest resourceRequest7 = new ResourceRequest(0.12);
        ResourceRequest resourceRequest8 = new ResourceRequest(0.32);
        ResourceRequest resourceRequest9 = new ResourceRequest(0.04);
        ResourceRequest resourceRequest10 = new ResourceRequest(0.08);

        dataCenterService.allocateResources(resourceRequest1);
        dataCenterService.allocateResources(resourceRequest2);
        dataCenterService.allocateResources(resourceRequest3);
        dataCenterService.allocateResources(resourceRequest4);
        dataCenterService.allocateResources(resourceRequest5);
        dataCenterService.allocateResources(resourceRequest6);
        dataCenterService.allocateResources(resourceRequest7);
        dataCenterService.allocateResources(resourceRequest8);
        dataCenterService.allocateResources(resourceRequest9);
        dataCenterService.allocateResources(resourceRequest10);

        dataCenter.getServers().forEach(server -> System.out.println(server));

        System.out.println();

        dataCenterService.optimize(dataCenter);

        dataCenter.getServers().forEach(server -> System.out.println(server));

    }
}
