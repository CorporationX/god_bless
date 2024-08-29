package faang.school.godbless.BJS2_25308;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources();
        marketingResources.addFile("Marketing");

        DesignResources designResources = new DesignResources();
        designResources.addFile("Design");

        DesignDepartment designDepartment = new DesignDepartment(() -> {
           marketingResources.readFiles();
//           processingInfo();
//            log.info("Inspired by marketing");
            designResources.addFile("Best design ever");
        });

        MarketingDepartment marketingDepartment = new MarketingDepartment(() -> {
            designResources.readFiles();
//            processingInfo();
//            log.info("Inspired by designers");
            marketingResources.addFile("Best marketing ever");
        });

        designDepartment.start();
        marketingDepartment.start();
    }

    private static void processingInfo(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error in thread: {}", e.getMessage());
        }
    }
}
