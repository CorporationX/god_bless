package school.faang.task_45019;

public class Main {
    private static final OptimizationStrategy loadOptimizationStrategy = new LoadBalancingOptimizationStrategy();
    private static final OptimizationStrategy energyOptimizationStrategy = new EnergyEfficiencyOptimizationStrategy();

    private static final DataCenterService dataCenterService = new DataCenterService();


    public static void main(String[] args) {
        initData();

        dataCenterService.setOptimizationStrategy(loadOptimizationStrategy);

        Server server = new Server(1100, 2000, 3000);
        dataCenterService.addServer(server);

        printResult();

        ResourceRequest resourceRequest = new ResourceRequest(1000);
        dataCenterService.allocateResources(resourceRequest);
        printResult();

        optimizeAndPrintResult();

        releaseResourcesAndPrintResult(resourceRequest);

        optimizeAndPrintResult();

        dataCenterService.allocateResources(new ResourceRequest(4000));
        printResult();

        releaseResourcesAndPrintResult(new ResourceRequest(2000));

        dataCenterService.setOptimizationStrategy(energyOptimizationStrategy);
        dataCenterService.optimize();
        System.out.println("After energy efficiency optimization.");
        printResult();

        dataCenterService.removeServer(server);
        printResult();
    }

    private static void initData() {
        dataCenterService.addServer(new Server(0, 1000, 500));
        dataCenterService.addServer(new Server(800, 1000, 800));
        dataCenterService.addServer(new Server(200, 500, 300));
        dataCenterService.addServer(new Server(0, 2000, 1000));
        dataCenterService.addServer(new Server(1500, 2000, 1200));
    }

    private static void printResult() {
        System.out.println("==========Result==========");
        System.out.printf("Total servers: %d%n", dataCenterService.getServerCount());
        System.out.printf("Total max load: %s%n", dataCenterService.getTotalMaxLoad());
        System.out.printf("Total energy consumption: %s%n", dataCenterService.getTotalEnergyConsumption());
        System.out.printf("Total load: %s%n", dataCenterService.getTotalLoad());
        dataCenterService.printAllServers();
        System.out.printf("--------------------------%n%n");
    }

    private static void optimizeAndPrintResult() {
        dataCenterService.optimize();
        System.out.println("After load balancing optimization.");
        printResult();
    }

    private static void releaseResourcesAndPrintResult(ResourceRequest resourceRequest) {
        dataCenterService.releaseResources(resourceRequest);
        System.out.printf("After resource release. Request: %s%n", resourceRequest);
        printResult();
    }


}
