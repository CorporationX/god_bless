package school.faang.optimizing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Server> servers = new ArrayList<>();
        servers.add(new Server(30, 100, 50));
        servers.add(new Server(50, 150, 70));
        servers.add(new Server(40, 200, 70));

        DataCenter dataCenter = new DataCenter();
        dataCenter.getServers().add(new Server(30, 100, 50));
        dataCenter.getServers().add(new Server(50, 150, 70));
        dataCenter.getServers().add(new Server(40, 200, 70));

        DataCenterService service = new DataCenterService();

        ResourceRequest request = new ResourceRequest(250);
        service.allocateResources(dataCenter, request);
        System.out.println("Total energy consumption: " + service.getTotalEnergyConsumption(dataCenter));

        OptimizationStrategy loadBalancingnStrategy = new LoadBalancingOptimizationStrategy();
        service.optimize(dataCenter, loadBalancingnStrategy);
        System.out.println("Total Energy Consumption after Load Balancing: " +
                service.getTotalEnergyConsumption(dataCenter));

        OptimizationStrategy energyEfficiencyStrategy = new EnergyEfficiencyOptimizationStrategy();
        service.optimize(dataCenter, energyEfficiencyStrategy);
        System.out.println("Total Energy Consumption after Energy Efficiency Optimization: "
                + service.getTotalEnergyConsumption(dataCenter));
    }
}
