package faang.school.godbless.datacentre;

public class Main {
    public static void main(String[] args) {
        DataCenterService dataService = new DataCenterService();
        dataService.addServer(new Server(0.0, 5.0, 10.0));
        dataService.addServer(new Server(0.0, 3.0, 15.0));
        dataService.addServer(new Server(0.0, 8.0, 20.0));
    }
}
