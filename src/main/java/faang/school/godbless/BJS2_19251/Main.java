package faang.school.godbless.BJS2_19251;

public class Main {
    public static void main(String[] args) {
        ResourceRequest request = new ResourceRequest(5);
        DataCenter dataCenter = new DataCenter();
        dataCenter.getServers().add(new Server(5, 10, 6));
        dataCenter.getServers().add(new Server(130, 140, 9));
        DataCenterService service = new DataCenterService(dataCenter);
        service.addServer(new Server(11, 16, 9));
        service.removeServer(new Server(5, 10, 6));
        System.out.println(service.getTotalEnergyConsumption());
        service.allocateResources(request);
        System.out.println("allocate: " + service.getServers());
        service.releaseResources(request);
        System.out.println("release: " + service.getServers());
        System.out.println(dataCenter.getServers());
        new LoadBalancingOptimizationStrategy().optimize(dataCenter);
        System.out.println(dataCenter);
    }
}
