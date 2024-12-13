package school.faang.task_45023;

public class Main {
    public static void main(String[] args) {
        Server server1 = new Server(0, 10, 8);
        Server server2 = new Server(0, 6, 5);
        Server server3 = new Server(0, 20, 16);

        DataCenter dataCenter = new DataCenter();
        DataCenterService service = new DataCenterService(dataCenter, new LoadBalancingOptimizationStrategy());

        service.addServer(server1);
        service.addServer(server2);
        service.addServer(server3);

        System.out.println(service.allocateResources(new ResourceRequest(12)));
        System.out.println(service);

        service.optimizeLoad();
        System.out.println(service);

        service.releaseResources(new ResourceRequest(8));
        System.out.println(service);

        System.out.println(service.allocateResources(new ResourceRequest(40)));
        System.out.println(service);
    }
}
