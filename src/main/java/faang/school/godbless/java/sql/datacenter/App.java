package faang.school.godbless.java.sql.datacenter;

public class App {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        dataCenterService.setOptimizationStrategy(new LoadBalancingOptimizationStrategy());

        dataCenterService.addNewServerToDataCenter(new Server(10, 50));
        dataCenterService.addNewServerToDataCenter(new Server(0, 40));
        dataCenterService.addNewServerToDataCenter(new Server(2, 70));
        dataCenterService.addNewServerToDataCenter(new Server(2, 80));
        dataCenterService.addNewServerToDataCenter(new Server(0, 50));

        ResourceRequest allocateResource = new ResourceRequest();
        allocateResource.setLoad(200);

        ResourceRequest releaseResource = new ResourceRequest();
        releaseResource.setLoad(170);

        System.out.println("Before allocate " + dataCenter);
        dataCenterService.allocateResources(allocateResource);
        System.out.println("After allocate " + dataCenter);
        System.out.println("Total consumption: " + dataCenterService.getTotalEnergyConsumption());

        System.out.println("-------------------");

        System.out.println("Before release " + dataCenter);
        dataCenterService.releaseResources(releaseResource);
        System.out.println("After release " + dataCenter);
        System.out.println("Total consumption: " + dataCenterService.getTotalEnergyConsumption());

    }
}
