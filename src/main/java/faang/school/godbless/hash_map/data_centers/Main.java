package faang.school.godbless.hash_map.data_centers;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter(List.of(
                new Server(23,100,24),
                new Server(38,100,38),
                new Server(89,100,40),
                new Server(90,100,38),
                new Server(89,100,12),
                new Server(38,100,38),
                new Server(100,100,33),
                new Server(38,100,38),
                new Server(89,100,55),
                new Server(100,100,48),
                new Server(89,100,62),
                new Server(10,100,84),
                new Server(100,100,17),
                new Server(1,100,64)));
        DataCenterService dataCenterService = new DataCenterService(dataCenter);

        System.out.println("Before:");
        double load1 = 0;
        for (var server : dataCenter.getServerList()) {
            System.out.println("Load: " + server.getLoad() +  " - Max load: " + server.getMaxLoad());
            load1 += server.getLoad();
        }

        System.out.println("before all load: " + load1);

        dataCenterService.optimizationLoad(new LoadBalancingOptimizationStrategy());
        System.out.println("After:");
        double load2 = 0;
        for (var server : dataCenter.getServerList()) {
            System.out.println("Load: " + server.getLoad() +  " - Max load: " + server.getMaxLoad());
            load2 += server.getLoad();
        }
        System.out.println("after load: " + load2);

        System.out.println("EnergyConsumption: " + dataCenterService.getTotalEnergyConsumption());

    }
}
