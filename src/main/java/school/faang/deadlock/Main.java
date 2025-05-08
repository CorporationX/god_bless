package school.faang.deadlock;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<String> marketingFile = List.of("M1", "M2");
        List<String> designFile = List.of("D1", "D2");

        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        marketingResources.getFiles().addAll(marketingFile);
        designResources.getFiles().addAll(designFile);

        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);

        Thread thread1 = new Thread(designDepartment);
        Thread thread2 = new Thread(marketingDepartment);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            log.error("Поток прерван", e);
            Thread.currentThread().interrupt();
        }

        System.out.println(marketingResources.getFiles());
        System.out.println(designResources.getFiles());
    }
}
