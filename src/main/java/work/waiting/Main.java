package work.waiting;

import lombok.extern.slf4j.Slf4j;
import work.waiting.department_resources.DesignResources;
import work.waiting.department_resources.MarketingResources;
import work.waiting.departments.DesignDepartment;
import work.waiting.departments.MarketingDepartment;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class Main {
    public static final int FILES_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        MarketingResources marketingResources = initMarketingResources();
        DesignResources designResources = initDesignResources();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources,
                lock);
        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources,
                lock);
        marketingDepartment.start();
        designDepartment.start();
        marketingDepartment.join();
        designDepartment.join();
        marketingResources.printAllFiles();
        log.info("----");
        designResources.printAllFiles();
    }

    private static MarketingResources initMarketingResources() {
        MarketingResources resources = new MarketingResources();
        for (int i = 0; i < FILES_COUNT; i++) {
            resources.addFile("marketing_file_" + i + ".txt");
        }

        return resources;
    }

    private static DesignResources initDesignResources() {
        DesignResources resources = new DesignResources();
        for (int i = 0; i < FILES_COUNT; i++) {
            resources.addFile("design_file_" + i + ".txt");
        }

        return resources;
    }
}
