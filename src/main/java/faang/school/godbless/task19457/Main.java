package faang.school.godbless.task19457;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Server> serverList = new ArrayList<>();
        Server server1 = new Server(55, 70);
        Server server2 = new Server(40, 65);
        Server server3 = new Server(30, 40);

        DataCenter dataCenter = new DataCenter(serverList);
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);
        //dataCenterService.removeServer(server1);
        System.out.println(serverList);

        System.out.println("TotalEnergyConsumption " + dataCenterService.getTotalEnergyConsumption());

        dataCenterService.allocateResources(new ResourceRequest(20));
        dataCenterService.allocateResources(new ResourceRequest(11));
        dataCenterService.allocateResources(new ResourceRequest(7));
        serverList.stream().map(Server::getLoad).forEach(System.out::println);

        System.out.println("оптимизация");
        dataCenterService.optimize(dataCenter);
        serverList.stream().map(Server::getLoad).forEach(System.out::println);


    }
}
