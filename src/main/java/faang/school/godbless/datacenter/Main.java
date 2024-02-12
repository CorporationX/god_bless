package faang.school.godbless.datacenter;

import java.util.ArrayList;

public class Main {
    public static void main(String... args) {
        ArrayList<Server> servers = new ArrayList<>();
        servers.add(new Server(10, 10, 10));
        servers.add( new Server(15,73,30));
        servers.add(new Server(40,64,40));
        servers.add(new Server(76,79,45));
        servers.add(new Server(300,400,100));
        servers.add(new Server(85,90,70));
        servers.add(new Server(44,100,50));
        servers.add(new Server(55,100,60));
        servers.add(new Server(66,100,70));
        servers.add(new Server(77,100,80));
        servers.add(new Server(88,100,100));
        servers.add(new Server(99,100,100));
        servers.add(new Server(10,100,20));
        servers.add(new Server(5,100,10));
        Server testServer = new Server(1,100,10);
        servers.add(testServer);
        DataCenter dataCenter = new DataCenter(servers);
        DataCenterService service = new DataCenterService(dataCenter);
        printAllServersLoad(dataCenter);
        service.runOptimization(new LoadBalancingOptimizationStrategy());
        System.out.println("After optimization");
        printAllServersLoad(dataCenter);
        service.addNewServer(10, 10 , 10);
        service.allocateResources(new ResourceRequest(100));
        printAllServersLoad(dataCenter);
        service.removeServerFromDataCenter(testServer);
        printAllServersLoad(dataCenter);
    }

    public static void printAllServersLoad(DataCenter dataCenter) {
        System.out.println("Current load: ");
        for (int i = 1; i <= dataCenter.getServerList().size(); i++) {
            Server server = dataCenter.getServerList().get(i-1);
            System.out.printf("Server %s is loaded on %s of %s", i, server.getLoad(), server.getMaxLoad());
            System.out.println();
        }
    }
}
