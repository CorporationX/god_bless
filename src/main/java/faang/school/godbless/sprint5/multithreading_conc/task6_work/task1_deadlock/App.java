package faang.school.godbless.sprint5.multithreading_conc.task6_work.task1_deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {
        MarketingResources marketingResources = new MarketingResources();
        marketingResources.addFile("marketing file#1");
        marketingResources.addFile("marketing file#2");
        marketingResources.addFile("marketing file#3");
        marketingResources.addFile("marketing file#4");
        marketingResources.addFile("marketing file#5");

        DesignResources designResources = new DesignResources();
        designResources.addFile("design file#1");
        designResources.addFile("design file#2");
        designResources.addFile("design file#3");
        designResources.addFile("design file#4");
        designResources.addFile("design file#5");

        designResources.addMarketingResources(marketingResources);
        marketingResources.addDesignResources(designResources);

        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources);
        DesignDepartment designDepartment = new DesignDepartment(marketingResources);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(marketingDepartment);
        executor.execute(designDepartment);

        executor.shutdown();

        while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {

        }

        System.out.println("Done");
    }
}
