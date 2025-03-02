package school.faang.theworkstands;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        MarketingDepartment marketing = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment design = new DesignDepartment(marketingResources, designResources);

        Thread marketingThread = new Thread(marketing);
        Thread designThread = new Thread(design);

        marketingThread.start();
        designThread.start();

        try {
            marketingThread.join();
            designThread.join();
        } catch (InterruptedException e) {
            log.error("Поток прерван во время выполнения задач отделов", e);
            Thread.currentThread().interrupt();
        }
    }
}
