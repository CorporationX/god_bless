package school.faang.works_holds;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static final int THREAD_COUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        Thread thread1 = new Thread(() -> new DesignDepartment(designResources, marketingResources).run());
        Thread thread2 = new Thread(() -> new MarketingDepartment(designResources, marketingResources).run());

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        log.info("Designs resources {}", designResources.getDesignResources());
        log.info("Marketing resources {}", marketingResources.getMarketingResources());
        System.out.println("The end of the program");
    }
}
