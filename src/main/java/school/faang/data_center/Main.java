package school.faang.data_center;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService();


        dataCenterService.addServer(dataCenter, new Server(0, 100, 10));
        dataCenterService.addServer(dataCenter, new Server(100, 100, 100));
        dataCenterService.addServer(dataCenter, new Server(100, 200, 300));
        dataCenterService.addServer(dataCenter, new Server(10, 50, 50));
        dataCenterService.addServer(dataCenter, new Server(200, 1000, 1000));
        dataCenterService.addServer(dataCenter, new Server(300, 400, 500));
        dataCenterService.addServer(dataCenter, new Server(20, 400, 1000));
        dataCenterService.addServer(dataCenter, new Server(0, 10, 100));
        dataCenterService.addServer(dataCenter, new Server(200, 200, 300));
        dataCenterService.addServer(dataCenter, new Server(0, 80, 100));

        log.info(dataCenter.toString());

        dataCenterService.deleteServer(dataCenter, new Server(0, 80, 100));
        log.info(dataCenter.toString());

        log.info(String.valueOf(dataCenterService.getTotalEnergyConsumption(dataCenter)));

        dataCenterService.allocateResources(dataCenter, new ResourceRequest(1000));
        log.info(dataCenter.toString());

        EnergyEfficiencyOptimizationStrategy energyEfficient = new EnergyEfficiencyOptimizationStrategy();
        dataCenterService.optimize(dataCenter, energyEfficient);
        log.info(dataCenter.toString());

        LoadBalancingOptimizationStrategy loadBalance = new LoadBalancingOptimizationStrategy();
        dataCenterService.optimize(dataCenter, loadBalance);
        log.info(dataCenter.toString());


    }
}
