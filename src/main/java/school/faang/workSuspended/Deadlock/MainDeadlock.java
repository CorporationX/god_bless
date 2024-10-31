package school.faang.workSuspended.Deadlock;

import java.util.List;

public class MainDeadlock {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources(List.of("DesignFile1", "DesignFile2"));
        MarketingResources marketingResources = new MarketingResources(List.of("MarketingFile1", "MarketingFile2"));

        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);

        Thread designThread = new Thread(designDepartment);
        Thread marketingThread = new Thread(marketingDepartment);

        designThread.start();
        marketingThread.start();
    }
}
