package faang.school.godbless;

public class Main21 {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        ResourceRequest request = new ResourceRequest();
        DataCenterService dataCenterService = new DataCenterService();
        request.setLoad(50);

        dataCenterService.addServer(dataCenter.serverList, 1, 30.0, 150.0, 100.0);
        dataCenterService.addServer(dataCenter.serverList, 2, 25.0, 140.0, 80.0);
        dataCenterService.addServer(dataCenter.serverList, 3, 40.0, 160.0, 120.0);

        dataCenterService.showServers(dataCenter.serverList);

        dataCenterService.removeServer(dataCenter.serverList, 2);

        dataCenterService.showServers(dataCenter.serverList);

        System.out.println();

        dataCenterService.getTotalEnergyConsumption(dataCenter.serverList);

        System.out.println();

        dataCenterService.allocateResources(dataCenter.serverList, request, 1);

        dataCenterService.showServers(dataCenter.serverList);
        System.out.println();

        dataCenterService.releaseResources(dataCenter.serverList, 3);

        dataCenterService.showServers(dataCenter.serverList);

        LoadOptimizationStrategy loadOptimizationStrategy = new LoadOptimizationStrategy();

        dataCenterService.optimizeLoadPeriodically(dataCenter, loadOptimizationStrategy, 30 * 60 * 1000);
    }

}
