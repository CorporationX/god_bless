package school.faang.multithreading.concurr.deadlock.recreate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREADS_COUNT = 2;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);

        executor.submit(marketingDepartment);
        executor.submit(designDepartment);

        executor.shutdown();
    }

    private static void shutdown() {
        executor.shutdown();
    }
}
