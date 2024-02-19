package faang.school.godbless.r_edzie.hashmaps.datacenter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Server s1 = new Server(10, 100, 10);
        Server s2 = new Server(20, 100, 20);
        Server s3 = new Server(30, 100, 30);
        Server s4 = new Server(40, 100, 40);
        Server s5 = new Server(50, 100, 50);
        Server s6 = new Server(60, 100, 60);
        ResourceRequest request1 = new ResourceRequest(30);
        ResourceRequest request2 = new ResourceRequest(40);

        DataCenter dataCenter = new DataCenter(new ArrayList<>(){{
                add(s1);
                add(s2);
                add(s3);
                add(s4);
                add(s5);
        }});

        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        dataCenterService.addServer(s6);
        dataCenterService.removeServer(s3);

        System.out.println(dataCenterService.getTotalEnergyConsumption());

        System.out.println(dataCenter);

        dataCenterService.releaseResources(request1);

        dataCenterService.allocateResources(request2);

        System.out.println(dataCenter);

        dataCenterService.optimize(new LoadBalancingOptimizationStrategy());

        System.out.println(dataCenter);
    }
}
