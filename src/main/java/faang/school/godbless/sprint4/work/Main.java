package faang.school.godbless.sprint4.work;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        MarketingResources marketingResources = new MarketingResources(semaphore);
        marketingResources.addFile("advertising.txt");
        marketingResources.addFile("marketing.txt");

        DesignResources designResources = new DesignResources(semaphore);
        designResources.addFile("design.txt");
        designResources.addFile("graphics.txt");

        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources);

        marketingDepartment.start();
        designDepartment.start();

        marketingDepartment.join();
        designDepartment.join();

    }
}
