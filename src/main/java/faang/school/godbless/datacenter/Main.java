package faang.school.godbless.datacenter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter(List.of(new Server(23,89,24),
                                                       new Server(38,108,38),
                                                       new Server(89,89,102),
                                                       new Server(120,400,38),
                                                       new Server(89,89,102),
                                                       new Server(38,108,38),
                                                       new Server(100,100,102),
                                                       new Server(38,108,38),
                                                       new Server(89,89,102),
                                                       new Server(100,100,38),
                                                       new Server(89,89,102),
                                                       new Server(200,400,38),
                                                       new Server(200,200,102),
                                                       new Server(1,97,11)));
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        System.out.println("Before:");
        for (var server : dataCenter.getServers()) {
            System.out.println("Load: " + server.getLoad() +  " - Max load: " + server.getMaxLoad());
        }
        dataCenterService.optimizeStorage(new LoadBalancingOptimizationStrategy());
        dataCenterService.allocateResources(new ResourceRequest(50));
        dataCenterService.releaseResources(new ResourceRequest(50));
        System.out.println("After:");
        for (var server : dataCenter.getServers()) {
            System.out.println("Load: " + server.getLoad() +  " - Max load: " + server.getMaxLoad());
        }
    }
}
