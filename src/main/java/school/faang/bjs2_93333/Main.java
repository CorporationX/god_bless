package school.faang.bjs2_93333;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        Thread thread1 = new Thread(new MarketingDepartment(marketingResources, designResources));
        Thread thread2 = new Thread(new DesignDepartment(designResources, marketingResources));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log.info("Все потоки закончили свою работу.");
    }
}
