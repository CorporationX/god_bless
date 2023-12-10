package faang.school.godbless.java_hashmap.optimizing_work_data_center;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService();

        ResourceRequest rr1 = new ResourceRequest(1, 30);
        ResourceRequest rr2 = new ResourceRequest(2, 50);
        ResourceRequest rr3 = new ResourceRequest(3, 80);
        ResourceRequest rr4 = new ResourceRequest(4, 90);
        ResourceRequest rr5 = new ResourceRequest(5, 100);

        dataCenterService.allocateResources(rr1);
        dataCenterService.allocateResources(rr2);
        dataCenterService.allocateResources(rr3);
        dataCenterService.allocateResources(rr4);
        dataCenterService.allocateResources(rr5);

        dataCenterService.releaseResources(rr5);



        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> dataCenterService.optimize(new LoadBalancingOptimizationStrategy()), 0, 30, TimeUnit.MINUTES);

    }
}
