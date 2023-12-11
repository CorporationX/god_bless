package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataCenter dc = new DataCenter();
        dc.listOfServers.add(new Server(20, 100, 20));
        dc.listOfServers.add(new Server(50, 120, 45));
        dc.listOfServers.add(new Server(100, 150, 67));
        DataCenterService dcs = new DataCenterService();
        DataCenterService.allocateResources(new ResourceRequest(170), dc);
        for (Server s : dc.listOfServers) {
            System.out.println(s);
        }
        DataCenterService.releaseResources(new ResourceRequest(200), dc);
        for (Server s : dc.listOfServers) {
            System.out.println(s);
        }
        dcs.optimize(dc);
        for (Server s : dc.listOfServers) {
            System.out.println(s);
        }
    }
}
