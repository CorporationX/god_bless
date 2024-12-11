package school.faang.task45030;

import school.faang.task45030.model.ResourceRequest;
import school.faang.task45030.model.Server;
import school.faang.task45030.service.DataCenterService;

public class Main {
    public static void main(String[] args) {

        Server server1 = new Server(0, 10, 110);
        Server server2 = new Server(0, 10, 120);
        Server server3 = new Server(0, 10, 90);
        Server server4 = new Server(0, 10, 80);
        Server server5 = new Server(0, 10, 100);

        DataCenterService service = new DataCenterService();
        service.addServer(server1);
        service.addServer(server2);
        service.addServer(server3);
        service.addServer(server4);
        service.addServer(server5);

        ResourceRequest request1 = new ResourceRequest(5);
        ResourceRequest request2 = new ResourceRequest(11);
        ResourceRequest request3 = new ResourceRequest(8);
        ResourceRequest request4 = new ResourceRequest(9);

        service.allocateResources(request1);
        service.allocateResources(request2);
        service.allocateResources(request3);
        service.allocateResources(request4);

        System.out.println("Total energy consumption before energy optimization: "
                + service.getTotalEnergyConsumption());
        service.optimizeByEnergy();
        System.out.println("Total energy consumption after energy optimization: "
                + service.getTotalEnergyConsumption());
        service.optimizeByLoad();

        service.releaseResources(request4);
        System.out.println("Total energy consumption before energy optimization: "
                + service.getTotalEnergyConsumption());
        service.optimizeByEnergy();
        System.out.println("Total energy consumption after energy optimization: "
                + service.getTotalEnergyConsumption());
        service.optimizeByLoad();

        service.removeServer(server1);
        service.removeServer(server5);

    }
}
