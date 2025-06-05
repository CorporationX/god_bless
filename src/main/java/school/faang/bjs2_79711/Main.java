package school.faang.bjs2_79711;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_79711.strategy.EnergyEfficiencyOptimizationStrategy;
import school.faang.bjs2_79711.strategy.LoadBalancingOptimizationStrategy;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Server> servers = new ArrayList<>(List.of(
                new Server(20, 100, 15.5),
                new Server(85, 120, 40.0),
                new Server(35, 100, 18.0),
                new Server(70, 80, 45.5),
                new Server(45, 100, 23.7)
        ));
        DataCenter dataCenter = new DataCenter(servers);
        DataCenterService service = new DataCenterService();

        service.addServer(dataCenter, new Server(0, 120, 10));
        log.info(servers.toString());

        service.removeServer(dataCenter, new Server(0, 120, 10));
        log.info(servers.toString());

        double totalEnergyConsumption = service.getTotalEnergyConsumption(dataCenter);
        log.info("Общее энергопотребление серверов: {}", totalEnergyConsumption);

        ResourceRequest resourceRequest130 = new ResourceRequest(130);
        boolean isAllocated = service.allocateResources(dataCenter, resourceRequest130);
        log.info("Ресурсы {} распределены? - {}", resourceRequest130.load(), isAllocated);
        log.info(servers.toString());

        ResourceRequest resourceRequest1300 = new ResourceRequest(1300);
        isAllocated = service.allocateResources(dataCenter, resourceRequest1300);
        log.info("Ресурсы {} распределены? - {}", resourceRequest1300.load(), isAllocated);
        log.info(servers.toString());

        service.releaseResources(dataCenter, resourceRequest130);
        log.info(servers.toString());

        service.optimizeLoad(dataCenter, new LoadBalancingOptimizationStrategy());
        log.info("Сервера после оптимизации нагрузки {}", servers);

        service.releaseResources(dataCenter, resourceRequest130);
        log.info(servers.toString());

        service.optimizeLoad(dataCenter, new EnergyEfficiencyOptimizationStrategy());
        totalEnergyConsumption = service.getTotalEnergyConsumption(dataCenter);
        log.info("Общее энергопотребление серверов после оптимизации энергозатрат: {}", totalEnergyConsumption);
    }
}
