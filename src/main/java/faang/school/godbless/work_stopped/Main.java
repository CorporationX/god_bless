package faang.school.godbless.work_stopped;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        marketingResources.addFile("New file in marketing department");
        designResources.addFile("New file in design department");

        DesignDepartment designDepartment = new DesignDepartment(() -> {
            designResources.addFile("Another design file");
            log.info(designResources.getFiles().toString());

            marketingResources.addFile("Another marketing file");
            log.info(marketingResources.getFiles().toString());
        });

        MarketingDepartment marketingDepartment = new MarketingDepartment(() -> {
            designResources.addFile("Another design file");
            log.info(designResources.getFiles().toString());

            marketingResources.addFile("Another marketing file");
            log.info(marketingResources.getFiles().toString());
        });

        designDepartment.start();
        marketingDepartment.start();
    }
}
