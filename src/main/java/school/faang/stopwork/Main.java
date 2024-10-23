package school.faang.stopwork;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int THREAD_COUNT_POOL = 2;
    private final static int MAX_TIME_WORK = 100;
    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources(List.of("4", "5", "6"));
        DesignResources designResources = new DesignResources(List.of("1", "2", "3"));

        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT_POOL);
        executor.submit(designDepartment);
        executor.submit(marketingDepartment);

        executor.shutdown();

        try {
            if (executor.awaitTermination(MAX_TIME_WORK, TimeUnit.SECONDS)) {
                System.out.println("Программа завершена");
            } else {
                System.out.println("Программа принудительно завершена");
            }
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван " + e);
            Thread.currentThread().interrupt();
        }
    }
}