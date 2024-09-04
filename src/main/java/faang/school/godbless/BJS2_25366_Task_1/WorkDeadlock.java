package faang.school.godbless.BJS2_25366_Task_1;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkDeadlock {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        var executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new DesignDepartment(designResources, marketingResources));
        executorService.execute(new MarketingDepartment(designResources, marketingResources));

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}