package faang.school.godbless.BJS2_19295;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);

        dataCenterService.addServer(new Server(0, 40, 10));
        dataCenterService.addServer(new Server(0, 70, 10));
        dataCenterService.addServer(new Server(0, 10, 10));

        dataCenterService.allocateResources(new ResourceRequest(50));
        System.out.println(dataCenter + "\n\n");
        dataCenterService.releaseResources(new ResourceRequest(40));
        System.out.println(dataCenter + "\n\n");

        dataCenterService.startOptimizationTImer(30 * 60);


    }
}
