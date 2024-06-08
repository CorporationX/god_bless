package faang.school.godbless.dataCenter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Server firstServer = Server.builder()
                .load(10.0)
                .maxLoad(100.0)
                .energyConsumption(10.0)
                .build();

        Server secondServer = Server.builder()
                .load(40.0)
                .maxLoad(70.0)
                .energyConsumption(40.0)
                .build();

        DataCenter dataCenter = new DataCenter();
        dataCenter.getServers().add(firstServer);

        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        dataCenterService.addServer(secondServer);

        Double totalEnergyConsumption = dataCenterService.getTotalEnergyConsumption();

        ResourceRequest resourceRequest = ResourceRequest.builder()
                .load(25.0)
                .build();

        boolean resourceRequest1 = dataCenterService.allocateResources(resourceRequest);
        boolean resourceRequest2 = dataCenterService.allocateResources(resourceRequest);
        boolean resourceRequest3 = dataCenterService.allocateResources(resourceRequest);
        boolean resourceRequest4 = dataCenterService.allocateResources(resourceRequest);
        boolean releaseResource = dataCenterService.releaseResources(resourceRequest);


        OptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();

        dataCenterService.optimize(List.of(strategy));

        var a = 5;
    }
}
