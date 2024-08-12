package faang.school.godbless.BJS2_19295;

public class Main {
    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService();

        dataCenterService.addServer(new Server(0, 40, 10));
        dataCenterService.addServer(new Server(0, 70, 10));
        dataCenterService.addServer(new Server(0, 10, 10));

        dataCenterService.allocateResources(new ResourceRequest(50));
        System.out.println(dataCenterService.getDataCenter() + "\n\n");
        dataCenterService.releaseResources(new ResourceRequest(40));
        System.out.println(dataCenterService.getDataCenter() + "\n\n");

        dataCenterService.scheduledOptimize(30 * 60);


    }
}
