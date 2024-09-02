package work.waiting;

import lombok.extern.slf4j.Slf4j;
import work.waiting.departments.DesignDepartment;
import work.waiting.departments.MarketingDepartment;
import work.waiting.departments.resources.Resources;

@Slf4j
public class Main {
    public static final int FILES_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        Resources marketingResources = initMarketingResources();
        Resources designResources = initDesignResources();
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources);
        marketingDepartment.start();
        designDepartment.start();
        marketingDepartment.join();
        designDepartment.join();
        marketingResources.printAllFiles();
        log.info("----");
        designResources.printAllFiles();
    }

    private static Resources initMarketingResources() {
        Resources resources = new Resources();
        for (int i = 0; i < FILES_COUNT; i++) {
            resources.addFile("marketing_file_" + i + ".txt");
        }

        return resources;
    }

    private static Resources initDesignResources() {
        Resources resources = new Resources();
        for (int i = 0; i < FILES_COUNT; i++) {
            resources.addFile("design_file_" + i + ".txt");
        }

        return resources;
    }
}
