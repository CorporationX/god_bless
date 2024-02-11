package faang.school.godbless.data_center;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        Server server1 = new Server(1000, 1200, 60);
        Server server2 = new Server(200, 500, 50);
        Server server3 = new Server(500, 600, 40);


        List<Server> serverList = new ArrayList<>();
        serverList.add(server1);
        serverList.add(server2);
        serverList.add(server3);
        System.out.println(serverList);

        DataCenter dataCenter = new DataCenter(serverList);

        DataCenterService service = new DataCenterService(dataCenter);

        Server server4 = new Server(0, 600, 40);
        service.addServer(server4);

        System.out.println(serverList);
        service.deleteServer(server3);

        System.out.println(serverList);

        ResourceRequest allocateResource1 = new ResourceRequest(400);

        service.allocateResources(allocateResource1);
        System.out.println(serverList);
        ResourceRequest releaseResource1 = new ResourceRequest(200);
        service.releaseResources(releaseResource1);
        System.out.println(serverList);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                service.optimize(dataCenter);
                System.out.println(serverList);
            }
        };
        long delay = 0;
        long period = 30 * 60 * 1000;
        timer.scheduleAtFixedRate(task, delay, period);


    }
}
