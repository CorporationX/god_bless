package faang.school.godbless.workstop.tasktwo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        designResources.addName("First");
        marketingResources.addName("Second");
        executorService.execute(new MarketingDepartment(designResources, marketingResources));
        executorService.execute(new DesignDepartment(designResources, marketingResources));

        executorService.shutdown();
        awaitTermination(executorService, 5);
    }

    private static void awaitTermination(ExecutorService executorService, int minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
