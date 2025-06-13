package school.faang.module1.bjs2_79747;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService service = new DataCenterService();

        Server server1 = new Server(0.0, 100.0, 50.0);
        Server server2 = new Server(0.0, 100.0, 60.0);
        Server server3 = new Server(0.0, 100.0, 70.0);

        service.addServer(dataCenter, server1);
        service.addServer(dataCenter, server2);
        service.addServer(dataCenter, server3);

        log.info("Добавлены 3 сервера");

        ResourceRequest request = new ResourceRequest(150.0);
        boolean allocated = service.allocateResources(dataCenter, request);

        log.info("Ресурсы распределены: {}", allocated);
        logServerLoads(dataCenter);

        OptimizationStrategy loadBalancing = new LoadBalancingOptimizationStrategy();
        service.optimize(dataCenter, loadBalancing);

        log.info("После LoadBalancingOptimizationStrategy:");
        logServerLoads(dataCenter);

        service.releaseResources(dataCenter, new ResourceRequest(50.0));
        log.info("Освобождено 50 единиц нагрузки");
        logServerLoads(dataCenter);

        OptimizationStrategy energyEfficiency = new EnergyEfficiencyOptimizationStrategy();
        service.optimize(dataCenter, energyEfficiency);
        log.info("После EnergyEfficiencyOptimizationStrategy:");
        logEnergyConsumption(dataCenter);

        double totalLoad = dataCenter.getServers().stream().mapToDouble(Server::getLoad).sum();
        double totalEnergy = service.getTotalEnergyConsumption(dataCenter);

        log.info("Общая нагрузка: {}", totalLoad);
        log.info("Общее энергопотребление: {}", totalEnergy);
    }

    private static void logServerLoads(DataCenter dataCenter) {
        int index = 1;
        for (Server server : dataCenter.getServers()) {
            log.info("Server {} load: {}", index++, server.getLoad());
        }
    }

    private static void logEnergyConsumption(DataCenter dataCenter) {
        int index = 1;
        for (Server server : dataCenter.getServers()) {
            log.info("Server {} energy: {}", index++, server.getEnergyConsumption());
        }
    }
}