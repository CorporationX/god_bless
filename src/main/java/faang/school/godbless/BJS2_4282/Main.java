package faang.school.godbless.BJS2_4282;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DataCenter parisDataCenter = new DataCenter((getServer()));
        DataCenter londonDataCenter = new DataCenter((getServer()));

        DataCenterService dataCenterService = new DataCenterService(parisDataCenter);

        dataCenterService.getAllInfo();
        dataCenterService.addServer(new Server());
        dataCenterService.getTotalEnergyConsumption();
        dataCenterService.allocateResources(new ResourceRequest(35));
        dataCenterService.getTotalEnergyConsumption();
        dataCenterService.releaseResources(new ResourceRequest(38));
        dataCenterService.getTotalEnergyConsumption();
        dataCenterService.optimize(parisDataCenter);
        dataCenterService.getAllInfo();
        dataCenterService.removeServer(4L);
        dataCenterService.removeServer(2L);
        dataCenterService.optimize(parisDataCenter);
        dataCenterService.getAllInfo();

        dataCenterService = new DataCenterService(londonDataCenter);

        System.out.println("London data service: ");
        dataCenterService.getAllInfo();
    }

    private static List<Server> getServer() {
       List<Server> servers = new ArrayList<>();
       servers.add(new Server());
       servers.add(new Server());
       servers.add(new Server());
       servers.add(new Server());
       servers.add(new Server());
       return servers;
    }
}
