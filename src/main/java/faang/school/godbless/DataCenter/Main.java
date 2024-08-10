package faang.school.godbless.DataCenter;

public class Main {

    private static final DataCenterService DATA_CENTER_SERVICE = new DataCenterService();

    public static void main(String[] args) {

        DATA_CENTER_SERVICE.addServerToDataCenter(new Server(50, 1));
        DATA_CENTER_SERVICE.addServerToDataCenter(new Server(50, 2));
        DATA_CENTER_SERVICE.addServerToDataCenter(new Server(100, 3));

        DATA_CENTER_SERVICE.allocateResources(new ResourceRequest(110));

        DATA_CENTER_SERVICE.deleteServerFromDataCenterById(3, false);

        System.out.println(DATA_CENTER_SERVICE.getTotalLoad());


        DATA_CENTER_SERVICE.getDataCenter().getServers().forEach(server -> System.out.println(server.getLoad()));
        DATA_CENTER_SERVICE.optimize();
        DATA_CENTER_SERVICE.getDataCenter().getServers().forEach(server -> System.out.println(server.getLoad()));

        System.out.println(DATA_CENTER_SERVICE.getTotalEnergyConsumption());
    }
}
