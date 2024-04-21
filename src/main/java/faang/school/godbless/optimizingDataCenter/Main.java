package faang.school.godbless.optimizingDataCenter;

public class Main {
    public static void main(String[] args) {
        DataCenterService myDataService = new DataCenterService();
        myDataService.addServer(100, 500);
        myDataService.addServer(200, 500);
        myDataService.addServer(150, 500);
        myDataService.addServer(300, 500);
        myDataService.addServer(250, 500);

        System.out.println("Before optimization:\n" + myDataService.getDataCenter().toString());
        LoadBalancingOptimizationStrategy loadBalancingOptimizationStrategy = new LoadBalancingOptimizationStrategy();
        loadBalancingOptimizationStrategy.optimize(myDataService.getDataCenter());
        System.out.println("After optimization by load:\n" + myDataService.getDataCenter().toString());
        System.out.println("Total energy consumption after optimization: " + myDataService.getTotalEnergyConsumption());

        myDataService.allocateResources(new ResourceRequest(500));
        myDataService.releaseResources(new ResourceRequest(100));
        myDataService.removeServer(myDataService.getDataCenter().getServers().get(0));
        EnergyEfficencyOptimizationStrategy energyEfficencyOptimizationStrategy = new EnergyEfficencyOptimizationStrategy();
        energyEfficencyOptimizationStrategy.optimize(myDataService.getDataCenter());
        System.out.println("After optimization by energy:\n" + myDataService.getDataCenter().toString());
    }
}
