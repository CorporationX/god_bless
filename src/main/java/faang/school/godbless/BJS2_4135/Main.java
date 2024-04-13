package faang.school.godbless.BJS2_4135;

import faang.school.godbless.BJS2_4135.models.DataCenter;
import faang.school.godbless.BJS2_4135.models.ResourceRequest;
import faang.school.godbless.BJS2_4135.models.Server;
import faang.school.godbless.BJS2_4135.optimizators.EnergyEfficiencyOptimizationStrategy;
import faang.school.godbless.BJS2_4135.optimizators.LoadBalancingOptimizationStrategy;
import faang.school.godbless.BJS2_4135.services.DataCenterService;

public class Main {
    public static void main(String[] args) {
        DataCenter googleDataCenter = new DataCenter();
        DataCenter amazonDataCenter = new DataCenter();

        DataCenterService googleDataCenterService = new DataCenterService(googleDataCenter, new LoadBalancingOptimizationStrategy());
        DataCenterService amazonDataCenterService = new DataCenterService(amazonDataCenter, new EnergyEfficiencyOptimizationStrategy());

        googleDataCenterService.addServer(new Server(10.0, 10.0));
        googleDataCenterService.addServer(new Server(70.0, 15.0));
        googleDataCenterService.addServer(new Server(150.0, 10.0));
        googleDataCenterService.addServer(new Server(90.0, 15.0));

        amazonDataCenterService.addServer(new Server(150.0, 10.0));
        amazonDataCenterService.addServer(new Server(200.0, 15.0));
        amazonDataCenterService.addServer(new Server(210.0, 20.0));

        ResourceRequest request1 = new ResourceRequest(50.0);
        ResourceRequest request2 = new ResourceRequest(60.0);
        ResourceRequest request3 = new ResourceRequest(100.0);
        ResourceRequest request4 = new ResourceRequest(30.0);

        googleDataCenterService.allocateResources(request1);
        googleDataCenterService.allocateResources(request2);
        googleDataCenterService.allocateResources(request3);
        googleDataCenterService.allocateResources(request4);

        amazonDataCenterService.allocateResources(request1);
        amazonDataCenterService.allocateResources(request2);
        amazonDataCenterService.allocateResources(request3);
        amazonDataCenterService.allocateResources(request4);


        System.out.println(googleDataCenter.getServers());
        googleDataCenterService.optimizeResources();
        System.out.println(googleDataCenter.getServers());

        System.out.println("==============================");

        System.out.println(amazonDataCenter.getServers());
        amazonDataCenterService.optimizeResources();
        System.out.println(amazonDataCenter.getServers());

        System.out.println("==============================");

        System.out.println(googleDataCenterService.getTotalLoad());
        System.out.println(request3.getLoad());
        googleDataCenterService.releaseResources(request3);
        System.out.println(googleDataCenter.getServers());
        googleDataCenterService.optimizeResources();
        System.out.println(googleDataCenter.getServers());
        System.out.println(googleDataCenterService.getTotalLoad());
    }
}
