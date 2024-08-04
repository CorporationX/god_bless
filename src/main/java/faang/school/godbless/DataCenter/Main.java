package faang.school.godbless.DataCenter;

public class Main {

    private static final DataCenterService DATA_CENTER_SERVICE = new DataCenterService();

    public static void main(String[] args) {
        DATA_CENTER_SERVICE.addServerToDataCenter(new Server(100));
        DATA_CENTER_SERVICE.addServerToDataCenter(new Server(80));
        DATA_CENTER_SERVICE.addServerToDataCenter(new Server(120));
        DATA_CENTER_SERVICE.allocateResources(new ResourceRequest(250));
        System.out.println(DATA_CENTER_SERVICE.getTotalLoad());
        DATA_CENTER_SERVICE.getDataCenter().getSERVERS().forEach( server -> System.out.println(server.getLoad()));
        DATA_CENTER_SERVICE.optimize();
        DATA_CENTER_SERVICE.getDataCenter().getSERVERS().forEach( server -> System.out.println(server.getLoad()));
        System.out.println(DATA_CENTER_SERVICE.getTotalEnergyConsumption());
    }
}
