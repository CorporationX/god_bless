package school.faang.data_center;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);

        dataCenterService.addServer(new Server(1, 0, 100, 10));
        dataCenterService.addServer(new Server(2, 100, 100, 100));
        dataCenterService.addServer(new Server(3, 100, 200, 300));
        dataCenterService.addServer(new Server(4, 10, 50, 50));
        dataCenterService.addServer(new Server(5, 200, 1000, 1000));
        dataCenterService.addServer(new Server(6, 300, 400, 500));
        dataCenterService.addServer(new Server(7, 20, 400, 1000));
        dataCenterService.addServer(new Server(8, 0, 10, 100));
        dataCenterService.addServer(new Server(9, 200, 200, 300));
        dataCenterService.addServer(new Server(10, 0, 80, 100));

        log.info(dataCenter.toString());

        dataCenterService.deleteServer(new Server(10, 0, 80, 100));
        log.info(dataCenter.toString());

        log.info(String.valueOf(dataCenterService.getTotalEnergyConsumption()));

        ResourceRequest resourceRequest = new ResourceRequest(1000);
        boolean hasFreeResources = dataCenterService.allocateResources(resourceRequest);
        log.info("It`s {} that your data center has free recources for a request of {}",
                hasFreeResources, resourceRequest.load());

        EnergyEfficiencyOptimizationStrategy energyEfficient = new EnergyEfficiencyOptimizationStrategy();
        dataCenterService.optimize(energyEfficient);
        log.info(dataCenter.toString());

        LoadBalancingOptimizationStrategy loadBalance = new LoadBalancingOptimizationStrategy();
        dataCenterService.optimize(loadBalance);
        log.info(dataCenter.toString());

        dataCenterService.releaseResources(new ResourceRequest(5000));
        log.info(dataCenter.toString());

    }
}
