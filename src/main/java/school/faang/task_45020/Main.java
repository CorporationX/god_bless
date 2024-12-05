package school.faang.task_45020;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService service = new DataCenterService(dataCenter, new LoadBalancingOptimizationStrategy());
        service.addServer(new Server(50, 50, 5));
        service.addServer(new Server(50, 150, 10));
        service.addServer(new Server(70, 200, 10));
        service.addServer(new Server(30, 40, 10));
        service.addServer(new Server(90, 130, 10));
        service.addServer(new Server(130, 130, 10));
        service.optimize(dataCenter);
    }
}
