package faang.school.godbless.datacentre;

public class Main {
    public static void main(String[] args) {
        DataCenterService dataService = new DataCenterService();
        dataService.addServer(new Server(1,0.0, 5.0, 10.0));
        dataService.addServer(new Server(2,0.0, 3.0, 15.0));
        dataService.addServer(new Server(3,0.0, 8.0, 20.0));

        dataService.allocateResources(new ResourceRequest(1, 1.0));
        dataService.allocateResources(new ResourceRequest(2, 2.0));
        dataService.allocateResources(new ResourceRequest(3, 3.0));
        dataService.allocateResources(new ResourceRequest(4, 2.0));
        dataService.allocateResources(new ResourceRequest(5, 3.0));
        dataService.getDataCenter().showServerRequests();
        System.out.println();

        System.out.println("Высвобождение ресурса в дата-центре");
        dataService.releaseResources(new ResourceRequest(3, 3.0));
        dataService.getDataCenter().showServerRequests();
        System.out.println();

        System.out.println("Оптимизация");
        dataService.optimize(dataService.getDataCenter());
        dataService.getDataCenter().showServerRequests();
    }
}
