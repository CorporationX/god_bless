package school.faang.bjs2_79739;

public class Main {
    public static void main(String[] args) {
        DataCenterService service = new DataCenterService();
        DataCenter dataCenter = new DataCenter();
        service.addServer(dataCenter, new Server(0));
        service.addServer(dataCenter, new Server(4));
        service.addServer(dataCenter, new Server(10));

        OptimizationStrategy efficiencyOptimizationStrategy = new EnergyEfficiencyOptimizationStrategy();
        dataCenter.getServers().forEach(System.out::println);
        service.optimize(dataCenter, efficiencyOptimizationStrategy);
        dataCenter.getServers().forEach(System.out::println);

        OptimizationStrategy loadBalancingOptimizationStrategy = new LoadBalancingOptimizationStrategy();
        service.addServer(dataCenter, new Server(31));
        Server server = new Server(75);
        service.addServer(dataCenter, server);
        service.addServer(dataCenter, new Server(12));
        service.optimize(dataCenter, loadBalancingOptimizationStrategy);
        System.out.println("Отображение состояние серверов, после оптимизации по нагрузке");
        dataCenter.getServers().forEach(System.out::println);

        service.allocateResources(dataCenter, new ResourceRequest(50));
        System.out.println("Отображение состояние серверов, после увеличения нагрузки");
        dataCenter.getServers().forEach(System.out::println);

        service.releaseResources(dataCenter, new ResourceRequest(100));
        System.out.println("Отображение состояние серверов, после снятия нагрузки");
        dataCenter.getServers().forEach(System.out::println);

        System.out.println("Отображение состояние серверов, после удаления сервера");
        service.removeServer(dataCenter, server);
        dataCenter.getServers().forEach(System.out::println);
    }
}
