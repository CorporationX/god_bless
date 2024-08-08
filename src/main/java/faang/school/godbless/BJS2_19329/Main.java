package faang.school.godbless.BJS2_19329;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter(new ArrayList<>(Arrays.asList(new Server(100),
                new Server(100),
                new Server(150),
                new Server(200)
        )));
        DataCenterService dataCenterService = new DataCenterService(dataCenter, new LoadBalancingOptimizationStrategy());
        dataCenterService.printDataCenterConfiguration();
        System.out.println("------------");
        System.out.println("Request new resources");
        dataCenterService.allocateResources(new ResourceRequest(1475));
        dataCenterService.printDataCenterConfiguration();
        System.out.println("All servers load: " + dataCenterService.getCurrentServersLoad());
        System.out.println("All servers energy consumption: " + dataCenterService.getTotalEnergyConsumption());

        System.out.println("=========================");
        System.out.println("Request release resources");
        dataCenterService.releaseResources(new ResourceRequest(654));
        dataCenterService.printDataCenterConfiguration();
        System.out.println("All servers load: " + dataCenterService.getCurrentServersLoad());
        System.out.println("All servers energy consumption: " + dataCenterService.getTotalEnergyConsumption());

        System.out.println("---------------------------");
        System.out.println("After optimization by percentage load");
        dataCenterService.optimize();
        dataCenterService.printDataCenterConfiguration();
        System.out.println("All servers load: " + dataCenterService.getCurrentServersLoad());
        System.out.println("All servers energy consumption: " + dataCenterService.getTotalEnergyConsumption());

        System.out.println("---------------------------");
        System.out.println("After optimization by energy consumption");
        dataCenterService.setOptimizationStrategy(new EnergyEfficencyOptimizationStrategy());
        dataCenterService.optimize();
        dataCenterService.printDataCenterConfiguration();
        System.out.println("All servers load: " + dataCenterService.getCurrentServersLoad());
        System.out.println("All servers energy consumption: " + dataCenterService.getTotalEnergyConsumption());

        System.out.println("----------------------------");
        System.out.println("After another one optimization by percentage load");
        dataCenterService.setOptimizationStrategy(new LoadBalancingOptimizationStrategy());
        dataCenterService.optimize();
        dataCenterService.printDataCenterConfiguration();
        System.out.println("All servers load: " + dataCenterService.getCurrentServersLoad());
        System.out.println("All servers energy consumption: " + dataCenterService.getTotalEnergyConsumption());
    }
}
