package school.faang.bjs2__86088;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Server> list = new ArrayList<>();
        Server serverMoscow = new Server(0, 1012030, 13);
        Server serverTver = new Server(0, 1012030, 13);
        Server serverSpb = new Server(0, 1012030, 13);
        Server serverKazan = new Server(0, 1012030, 13);
        Server serverPronvino = new Server(0, 1012030, 13);
        Server serverSochi = new Server(0, 1012030, 13);
        Server serverNovosib = new Server(0, 1012030, 13);

        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService();
        dataCenterService.addServer(dataCenter, serverMoscow);
        dataCenterService.addServer(dataCenter, serverTver);
        dataCenterService.addServer(dataCenter, serverSpb);
        dataCenterService.addServer(dataCenter, serverKazan);
        dataCenterService.addServer(dataCenter, serverPronvino);
        dataCenterService.addServer(dataCenter, serverSochi);
        dataCenterService.addServer(dataCenter, serverNovosib);
        ResourceRequest request = new ResourceRequest(5003103);
        dataCenterService.allocateResources(dataCenter, request);
        System.out.println(dataCenter.getListServer());
        System.out.println();
        dataCenterService.setOptimizationStrategy(new EnergyEfficiencyOptimizationStrategy());
        dataCenterService.optimizeLoad(dataCenter, request);
        System.out.println(dataCenter.getListServer());
        System.out.println();
        dataCenterService.setOptimizationStrategy(new LoadBalancingOptimizationStrategy());
        dataCenterService.optimizeLoad(dataCenter, request);
        System.out.println(dataCenter.getListServer());
        System.out.println();
        dataCenterService.releaseResource(dataCenter, request);
        System.out.println(dataCenter.getListServer());
        System.out.println();
    }
}
