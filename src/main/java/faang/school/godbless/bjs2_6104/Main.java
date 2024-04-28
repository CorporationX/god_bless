package faang.school.godbless.bjs2_6104;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        designResources.addResource("design1");
        marketingResources.addResource("marketing1");

        DesignDepartment designDepartment = new DesignDepartment(() -> {
            marketingResources.getLock().readLock().lock();
            marketingResources.printResources();
            marketingResources.getLock().readLock().unlock();

            designResources.getLock().writeLock().lock();
            designResources.addResource("Design resource");
            designResources.getLock().writeLock().unlock();

        });

        MarketingDepartment marketingDepartment = new MarketingDepartment(() -> {
            designResources.getLock().readLock().lock();
            designResources.printResources();
            designResources.getLock().readLock().unlock();

            marketingResources.getLock().writeLock().lock();
            marketingResources.addResource("Marketing resource");
            marketingResources.getLock().writeLock();
        });

        designDepartment.start();
        marketingDepartment.start();
    }
}
