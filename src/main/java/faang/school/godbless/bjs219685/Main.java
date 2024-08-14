package faang.school.godbless.bjs219685;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        OptimizationStrategy loadBalancingStrategy = new LoadBalancingOptimizationStrategy();
        OptimizationStrategy energyEfficencyStrategy = new EnergyEfficencyOptimizationStrategy();
        DataCenterService dataCenterService = new DataCenterService(dataCenter, loadBalancingStrategy);

        dataCenterService.addServer(new Server(80, 100, 80));
        dataCenterService.addServer(new Server(35, 100, 50));
        dataCenterService.addServer(new Server(95, 100, 85));

        dataCenterService.optimize();
        dataCenterService.printServersState();
        dataCenterService.addServer(new Server(0, 100, 50));
        dataCenterService.optimize();
        dataCenterService.printServersState();
        dataCenterService.setOptimizationStrategy(energyEfficencyStrategy);
        dataCenterService.optimize();
        dataCenterService.setOptimizationStrategy(loadBalancingStrategy);
        dataCenterService.optimize();
        dataCenterService.printServersState();


    }
}
