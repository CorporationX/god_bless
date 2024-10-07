package school.faang.data_center;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataCenterService dataCenterService = new DataCenterService(new DataCenter());
        dataCenterService.addServerToDataCenter(new Server(230.5, 100.0, 50));
        dataCenterService.addServerToDataCenter(new Server(10.5, 100.0, 50));
        dataCenterService.addServerToDataCenter(new Server(25.5, 100.0, 50));

        dataCenterService.allocateResources(new ResourceRequest(34.5));
        dataCenterService.optimize(dataCenterService.getDataCenter());
        for (Server server : dataCenterService.getDataCenter().getServers()) {
            System.out.println("Загркзка сервера равна = " + server.getLoad());
        }
    }
}
