package faang.school.godbless.workisstoped;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        marketingResources.addResource("New file in marketing department");
        designResources.addResource("New file in design department");

        DesignDepartment designDepartment = new DesignDepartment(() -> {
            designResources.addResource("Another design file");
            designResources.printResources();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            marketingResources.addResource("Another marketing file");
            marketingResources.printResources();
        });

        MarketingDepartment marketingDepartment = new MarketingDepartment(() -> {
            marketingResources.addResource("Another design file");
            marketingResources.printResources();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }

            designResources.addResource("Another design file");
            designResources.printResources();
        });

        designDepartment.start();
        marketingDepartment.start();
    }
}
