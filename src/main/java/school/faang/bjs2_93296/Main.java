package school.faang.bjs2_93296;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        executor.execute(new DesignDepartment(designResources, marketingResources));
        executor.execute(new MarketingDepartment(designResources, marketingResources));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println(designResources.readFiles());
        System.out.println(marketingResources.readFiles());
    }
}
