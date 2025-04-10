package school.faang.datacenter_work_optimization;


import school.faang.datacenter_work_optimization.model.DataCenter;
import school.faang.datacenter_work_optimization.model.ResourceRequest;
import school.faang.datacenter_work_optimization.model.Server;
import school.faang.datacenter_work_optimization.services.DataCenterService;
import school.faang.datacenter_work_optimization.services.EnergyEfficiencyOptimizationStrategy;
import school.faang.datacenter_work_optimization.services.LoadBalancingOptimizationStrategy;
import school.faang.datacenter_work_optimization.services.OptimizationStrategy;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();

        // === Инициализация серверов ===
        Server server1 = createServer(100, 50, 200); // efficiency 2.0
        Server server2 = createServer(150, 70, 180); // efficiency 1.2
        Server server3 = createServer(80, 30, 160);  // efficiency 2.0

        DataCenterService.addServer(dataCenter, server1);
        DataCenterService.addServer(dataCenter, server2);
        DataCenterService.addServer(dataCenter, server3);

        System.out.println("== Состояние до оптимизации ==");
        DataCenterService.printServers(dataCenter);

        // === Load Balancing Optimization ===
        OptimizationStrategy loadBalancing = new LoadBalancingOptimizationStrategy();
        loadBalancing.optimize(dataCenter);
        System.out.println("\n== После LoadBalancingOptimization ==");
        DataCenterService.printServers(dataCenter);

        // Сбрасываем нагрузки
        server1.setLoad(50);
        server2.setLoad(70);
        server3.setLoad(30);

        // === Energy Efficiency Optimization ===
        OptimizationStrategy energyEfficient = new EnergyEfficiencyOptimizationStrategy();
        energyEfficient.optimize(dataCenter);
        System.out.println("\n== После EnergyEfficiencyOptimization ==");
        DataCenterService.printServers(dataCenter);

        // === Энергопотребление ===
        System.out.printf("%n== Общее энергопотребление: %.2f Вт ==%n",
                DataCenterService.getTotalEnergyConsumption(dataCenter));

        // === Выделение ресурсов ===
        ResourceRequest allocate = new ResourceRequest();
        allocate.setLoad(120);
        boolean success = DataCenterService.allocateResource(dataCenter, allocate);
        System.out.printf("%n== Запрос на выделение 120 нагрузки: %s ==%n",
                success ? "УСПЕШНО" : "ОТКАЗ — недостаточно ресурсов");

        // === Освобождение ресурсов ===
        ResourceRequest release = new ResourceRequest();
        release.setLoad(60);
        DataCenterService.releaseResource(dataCenter, release);
        System.out.println("\n== После освобождения 60 нагрузки ==");
        DataCenterService.printServers(dataCenter);

        // === Удаление сервера ===
        DataCenterService.removeServer(dataCenter, server2);
        System.out.println("\n== После удаления сервера ==");
        DataCenterService.printServers(dataCenter);
    }

    private static Server createServer(double maxLoad, double load, double energy) {
        Server server = new Server();
        server.setMaxLoad(maxLoad);
        server.setLoad(load);
        server.setEnergyConsumption(energy);
        return server;
    }
}
