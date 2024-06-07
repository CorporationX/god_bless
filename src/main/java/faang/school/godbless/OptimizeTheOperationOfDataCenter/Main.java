package faang.school.godbless.OptimizeTheOperationOfDataCenter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Server s1 = new Server(12.3, 80.0);
        Server s2 = new Server(12.3, 80.0);
        Server s3 = new Server(12.3, 80.0);
        Server s4 = new Server(12.3, 80.0);
        List<Server> all = new ArrayList<>();
        all.add(s1);
        all.add(s2);
        all.add(s3);
        all.add(s4);
        DataCenter dataCenter = new DataCenter(all);

//        ResourceRequest resourceRequest = new ResourceRequest(100.2);
//        dataCenter.allocateResources(resourceRequest);
        dataCenter.releaseResources(new ResourceRequest(90.5));
    }
}
