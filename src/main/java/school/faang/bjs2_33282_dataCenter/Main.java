package school.faang.bjs2_33282_dataCenter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService();

        System.out.println(dataCenter.getServers());

        List<ResourceRequest> requestList = new ArrayList<>(List.of(
                new ResourceRequest(25, true),
                new ResourceRequest(100, true),
                new ResourceRequest(40, false),
                new ResourceRequest(150, true)
        ));

        dataCenterService.initiateDataCenter(dataCenter, requestList);

        System.out.println(dataCenter.getServers());

        dataCenterService.loadBalancingOptimizationStrategy(dataCenter, 45);
        System.out.println(dataCenter.getServers());

        dataCenterService.loadBalancingOptimizationStrategy(dataCenter, 60);
        System.out.println(dataCenter.getServers());

    }
}
