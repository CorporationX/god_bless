package school.faang.bjs2_79739;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService.addServer(dataCenter, new Server(0));
        DataCenterService.addServer(dataCenter, new Server(4));
        DataCenterService.addServer(dataCenter, new Server(10));

        OptimizationStrategy efficiencyOptimizationStrategy = new EnergyEfficiencyOptimizationStrategy();
        dataCenter.getServers().forEach(System.out::println);
        DataCenterService.optimize(dataCenter, efficiencyOptimizationStrategy);
        dataCenter.getServers().forEach(System.out::println);

        OptimizationStrategy loadBalancingOptimizationStrategy = new LoadBalancingOptimizationStrategy();
        DataCenterService.addServer(dataCenter, new Server(31));
        Server server = new Server(75);
        DataCenterService.addServer(dataCenter, server);
        DataCenterService.addServer(dataCenter, new Server(12));
        DataCenterService.optimize(dataCenter, loadBalancingOptimizationStrategy);
        System.out.println("Отображение состояние серверов, после оптимизации по нагрузке");
        dataCenter.getServers().forEach(System.out::println);

        DataCenterService.allocateResources(dataCenter, new ResourceRequest(50));
        System.out.println("Отображение состояние серверов, после увеличения нагрузки");
        dataCenter.getServers().forEach(System.out::println);

        DataCenterService.releaseResources(dataCenter, new ResourceRequest(100));
        System.out.println("Отображение состояние серверов, после снятия нагрузки");
        dataCenter.getServers().forEach(System.out::println);

        System.out.println("Отображение состояние серверов, после удаления сервера");
        DataCenterService.removeServer(dataCenter, server);
        dataCenter.getServers().forEach(System.out::println);
    }
}
