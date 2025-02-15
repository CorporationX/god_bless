package school.faang.optimizing;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        dataCenter.addServer(new Server(30, 100, 50));
        dataCenter.addServer(new Server(50, 150, 70));
        dataCenter.addServer(new Server(40, 200, 70));

        DataCenterService service = new DataCenterService();
        ResourceRequest request = new ResourceRequest(250);
        service.allocateResources(dataCenter, request);
        System.out.println("Total energy consumption: " + DataCenterService.getTotalEnergyConsumption(dataCenter));

        OptimizationStrategy loadBalancingStrategy = new LoadBalancingOptimizationStrategy();
        service.optimize(dataCenter, loadBalancingStrategy);
        System.out.println("Total Energy Consumption after Load Balancing: " +
                DataCenterService.getTotalEnergyConsumption(dataCenter));

        OptimizationStrategy energyEfficiencyStrategy = new EnergyEfficiencyOptimizationStrategy();
        service.optimize(dataCenter, energyEfficiencyStrategy);
        System.out.println("Total Energy Consumption after Energy Efficiency Optimization: "
                + DataCenterService.getTotalEnergyConsumption(dataCenter));
    }
}
